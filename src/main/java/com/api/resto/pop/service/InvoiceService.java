package com.api.resto.pop.service;

import com.api.resto.pop.dto.InvoiceResponseDto;
import com.api.resto.pop.dto.OrderResponseDto;
import com.api.resto.pop.entity.Invoice;
import com.api.resto.pop.entity.TableOrder;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    TableService tableService;

//    @Autowired
//    OrderService orderService;


    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    OrderService x = new OrderService();
    HashMap<Integer, OrderResponseDto> orders = x.getHashMap();

   private static HashMap<Integer, InvoiceResponseDto> totalOrders = new HashMap();

   public HashMap<Integer, InvoiceResponseDto> getHashTotal() {
       return totalOrders;
   }

    public InvoiceResponseDto showOrder(Integer tableId) {
        TableOrder tableOrder = tableService.findByIdTable(tableId);


//        OrderFood order = orderService.findByIdOrder(invoiceRequestDto.getIdOrder());
//        Integer getIdOrder = order.getIdOrder();
//        Integer getIdTable = order.getIdTable();
//        Integer getIdMenu = order.getIdMenu();
//        Integer getNumberTable = order.getNumberTable();
//        String getNameMenu = order.getNameMenu();
//        BigDecimal getPriceMenu = order.getPriceMenu();
//        Integer getQuantityMenu = order.getQuantityMenu();
//        BigDecimal tax = BigDecimal.valueOf(0.1);
//        BigDecimal serviceCharge = BigDecimal.valueOf(0.15);


//        Invoice invoice = new Invoice();
//        invoice.setIdOrder(invoiceRequestDto.getIdOrder());
//        invoice.setIdTable(invoiceRequestDto.getIdTable());
//        invoiceRepository.save(invoice);

        InvoiceResponseDto  invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setIdTable(tableOrder.getIdTable());
        invoiceResponseDto.setNumberTable(tableId);
        invoiceResponseDto.setAllOrder(orders.values());
        Integer totalQty = totalInvoice().getTotalQty();
        invoiceResponseDto.setTotalQty(totalQty);
        BigDecimal subTotal = totalInvoice().getSubTotal();
        invoiceResponseDto.setSubTotal(subTotal);
        BigDecimal tax = subTotal.multiply(BigDecimal.valueOf(0.1));
        invoiceResponseDto.setTax(tax);
        BigDecimal serviceCharge = subTotal.multiply(BigDecimal.valueOf(0.15));
        invoiceResponseDto.setServiceCharge(serviceCharge);
        BigDecimal totalAmount = subTotal.add(tax).add(serviceCharge);
        invoiceResponseDto.setTotalAmount(totalAmount);



//        BigDecimal subTotal = getPriceMenu.multiply(new BigDecimal(getQuantityMenu));
//        BigDecimal discount = BigDecimal.valueOf(10000);
//        BigDecimal tax = subTotal.multiply(BigDecimal.valueOf(0.10));
//        BigDecimal serviceCharge = subTotal.multiply(BigDecimal.valueOf(0.15));
//        BigDecimal totalAmount = subTotal.add(tax).add(serviceCharge);
//
//        Integer discountQty = getQuantityMenu/5;
//        BigDecimal getDiscount = discount.multiply(new BigDecimal(discountQty));
//        BigDecimal totalAmountDiscount;

//        Invoice invoice = new Invoice();
//        invoice.setIdOrder(invoiceRequestDto.getIdOrder());
//        invoice.setIdTable(invoiceRequestDto.getIdTable());
//        invoice.setNameMenu(getNameMenu);
//        invoice.setPriceMenu(getPriceMenu);
//        invoice.setIdMenu(getIdMenu);
//        invoice.setNumberTable(getNumberTable);
//        invoice.setQuantityMenu(getQuantityMenu);
//        invoice.setServiceCharge(serviceCharge);
//        invoice.setSubTotal(subTotal);
//        invoice.setTax(tax);


//        if (discountQty > 5) {
//            getDiscount = BigDecimal.valueOf(50000);
//        }
//         totalAmountDiscount = totalAmount.subtract(getDiscount);
//
//        invoice.setDiscount(getDiscount);
//        invoice.setTotalAmount(totalAmountDiscount);

//        invoiceRepository.save(invoice);

//        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
//        invoiceResponseDto.setIdInvoice(invoice.getIdInvoice());
//        invoiceResponseDto.setIdOrder(getIdOrder);
//        invoiceResponseDto.setNumberTable(getNumberTable);
//        invoiceResponseDto.setIdTable(getIdTable);
//        invoiceResponseDto.setNameMenu(getNameMenu);
//        invoiceResponseDto.setPriceMenu(getPriceMenu);
//        invoiceResponseDto.setQuantityMenu(getQuantityMenu);

//        invoiceResponseDto.setAllOrder(orders.values());
//        invoiceResponseDto.setSubTotal(subTotal);
//        invoiceResponseDto.setTax(tax);
//        invoiceResponseDto.setServiceCharge(serviceCharge);
//        invoiceResponseDto.setDiscount(getDiscount);
//        invoiceResponseDto.setTotalAmount(totalAmountDiscount);
//
//
//        return invoiceResponseDto;
        totalOrders.put(tableId, invoiceResponseDto);
        log.info("Ini yg total semuanya: " + totalOrders.toString());
        return invoiceResponseDto;

    }

    private InvoiceResponseDto totalInvoice() {
        InvoiceResponseDto invoiceResponseDtos = new InvoiceResponseDto();

        Integer totalQtyMenu = 0;
        BigDecimal subTotal = BigDecimal.valueOf(0);

        HashMap<Integer, OrderResponseDto> map = orders;
        for (Map.Entry<Integer, OrderResponseDto> x: map.entrySet()) {
            BigDecimal price = x.getValue().getPriceMenu();
            Integer qty = x.getValue().getQuantityMenu();
            BigDecimal subTotals = price.multiply(new BigDecimal(qty));

            totalQtyMenu += x.getValue().getQuantityMenu();
            subTotal = subTotal.add(subTotals);

            invoiceResponseDtos.setSubTotal(subTotal);
            invoiceResponseDtos.setTotalQty(totalQtyMenu);
        }

        return invoiceResponseDtos;
    }

    public Collection<InvoiceResponseDto> listTotalOrder() {
        return totalOrders.values();
    }

    public Invoice findByIdInvoice(Integer id) {
        return invoiceRepository.findByIdInvoice(id);
    }
}
