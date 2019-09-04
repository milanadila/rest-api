package com.api.resto.pop.service;

import com.api.resto.pop.dto.InvoiceResponseDto;
import com.api.resto.pop.dto.InvoiceRequestDto;
import com.api.resto.pop.entity.Invoice;
import com.api.resto.pop.entity.OrderFood;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        Integer getIdMenu = order.getIdMenu();
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
        BigDecimal totalAmountAfterDiscount1 = totalAmount.subtract(discount1);
        BigDecimal totalAmountAfterDiscount2 = totalAmount.subtract(discount2);

        Invoice invoice = new Invoice();
        invoice.setIdOrder(invoiceRequestDto.getIdOrder());
        invoice.setIdTable(invoiceRequestDto.getIdTable());
        invoice.setNameMenu(getNameMenu);
        invoice.setPriceMenu(getPriceMenu);
        invoice.setIdMenu(getIdMenu);
        invoice.setNumberTable(getNumberTable);
        invoice.setQuantityMenu(getQuantityMenu);
        invoice.setServiceCharge(serviceCharge);
        invoice.setSubTotal(subTotal);
        invoice.setTax(tax);
        if (totalAmount.compareTo(BigDecimal.valueOf(500000)) > 0) {
            invoice.setDiscount(discount1);
            invoice.setTotalAmount(totalAmountAfterDiscount1);
        } else if (totalAmount.compareTo(BigDecimal.valueOf(300000)) > 0) {
            invoice.setDiscount(discount2);
            invoice.setTotalAmount(totalAmountAfterDiscount2);
        } else {
            invoice.setDiscount(BigDecimal.valueOf(0));
            invoice.setTotalAmount(totalAmount);
        }
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
            invoiceResponseDto.setTotalAmount(totalAmountAfterDiscount1);
        } else if (totalAmount.compareTo(BigDecimal.valueOf(300000)) > 0) {
            invoiceResponseDto.setDiscount(discount2);
            invoiceResponseDto.setTotalAmount(totalAmountAfterDiscount2);
        } else {
            invoiceResponseDto.setDiscount(BigDecimal.valueOf(0));
            invoiceResponseDto.setTotalAmount(totalAmount);
        }

        return invoiceResponseDto;

    }

    public Invoice findByIdInvoice(Integer id) {
        return invoiceRepository.findByIdInvoice(id);
    }
}
