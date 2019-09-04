package com.api.resto.pop.service;

import com.api.resto.pop.dto.InvoiceResponseDto;
import com.api.resto.pop.dto.InvoiceRequestDto;
import com.api.resto.pop.dto.MenuResponseDto;
import com.api.resto.pop.dto.OrderResponseDto;
import com.api.resto.pop.entity.Invoice;
import com.api.resto.pop.entity.OrderFood;
import com.api.resto.pop.entity.TableOrder;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.InvoiceRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    OrderService orderService;


    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice findById(Integer id) {
        return invoiceRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    public InvoiceResponseDto doPayment(InvoiceRequestDto invoiceRequestDto) {

        OrderFood order = orderService.findByIdOrder(invoiceRequestDto.getIdOrder());
        Integer getIdOrder = order.getIdOrder();
        Integer getIdTable = order.getIdTable();
        Integer getNumberTable = order.getNumberTable();
        String getNameMenu = order.getNameMenu();
        BigDecimal getPriceMenu = order.getPriceMenu();
        Integer getQuantityMenu = order.getQuantityMenu();

        BigDecimal subTotal = getPriceMenu.multiply(new BigDecimal(getQuantityMenu));
        BigDecimal tax = getPriceMenu.multiply(BigDecimal.valueOf(0.10));
        BigDecimal serviceCharge = getPriceMenu.multiply(BigDecimal.valueOf(0.15));
        BigDecimal totalAmount = subTotal.add(tax).add(serviceCharge);
        BigDecimal discount1 = BigDecimal.valueOf(100000);
        BigDecimal discount2 = BigDecimal.valueOf(60000);
        BigDecimal totalAmountAfterDiscount1;
        BigDecimal totalAmountAfterDiscount2;

        Invoice invoice = new Invoice();
        invoice.setIdOrder(invoiceRequestDto.getIdOrder());
        invoice.setIdTable(invoiceRequestDto.getIdTable());
        invoice.setNameMenu(getNameMenu);
        invoice.setPriceMenu(getPriceMenu);
        invoiceRepository.save(invoice);

        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setIdInvoice(invoice.getIdInvoice());
        invoiceResponseDto.setIdOrder(getIdOrder);
        invoiceResponseDto.setNumberTable(getNumberTable);
        invoiceResponseDto.setIdTable(getIdTable);
        invoiceResponseDto.setNameMenu(getNameMenu);
        invoiceResponseDto.setPriceMenu(getPriceMenu);
        invoiceResponseDto.setQuantityMenu(getQuantityMenu);
        invoiceResponseDto.setSubTotal(subTotal);
        invoiceResponseDto.setTax(tax);
        invoiceResponseDto.setServiceCharge(serviceCharge);
        if (totalAmount.compareTo(BigDecimal.valueOf(500000)) > 0) {
            invoiceResponseDto.setDiscount(discount1);
            totalAmountAfterDiscount1 = totalAmount.subtract(discount1);
            invoiceResponseDto.setTotalAmount(totalAmountAfterDiscount1);
        } else if (totalAmount.compareTo(BigDecimal.valueOf(300000)) > 0) {
            invoiceResponseDto.setDiscount(discount2);
            totalAmountAfterDiscount2 = totalAmount.subtract(discount2);
            invoiceResponseDto.setTotalAmount(totalAmountAfterDiscount2);
        } else {
            invoiceResponseDto.setDiscount(BigDecimal.valueOf(0));
            invoiceResponseDto.setTotalAmount(totalAmount);
        }

        return invoiceResponseDto;

    }
}
