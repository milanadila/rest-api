package com.api.resto.pop.service;

import com.api.resto.pop.dto.InvoiceRequestDto;
import com.api.resto.pop.dto.InvoiceResponseDto;
import com.api.resto.pop.entity.Invoice;
import com.api.resto.pop.exception.IdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class InvoiceServiceTest {

    @Autowired
    InvoiceService invoiceService;

    InvoiceResponseDto invoiceResponseDto;

    @Before
    public void preDefine(){

//        invoiceResponseDto = new InvoiceResponseDto();
//        invoiceResponseDto.setIdInvoice(1);
//        invoiceResponseDto.setQuantityMenu(1);
//        invoiceResponseDto.setNameMenu("Grilled Atlantic Salmon Steak");
//        invoiceResponseDto.setIdOrder(1);
//        invoiceResponseDto.setIdTable(1);
//        invoiceResponseDto.setNumberTable(1);
    }

    @Test
    public void findAll() {
        List<Invoice> invoiceTest = invoiceService.findAll();
        assertThat(invoiceTest.size()).isNotNull();
        for (int i = 0; i < invoiceTest.size(); i++) {
        }
    }

    @Test
    public void findById() {
        Integer id = 1;
        Invoice invoice = invoiceService.findById(id);

        assertThat(invoice)
                .hasFieldOrProperty("idInvoice")
                .hasFieldOrProperty("idTable")
                .hasFieldOrProperty("numberTable")
                .hasFieldOrProperty("idOrder")
                .hasFieldOrProperty("idMenu")
                .hasFieldOrProperty("nameMenu")
                .hasFieldOrProperty("priceMenu")
                .hasFieldOrProperty("quantityMenu")
                .hasFieldOrProperty("subTotal")
                .hasFieldOrProperty("tax")
                .hasFieldOrProperty("serviceCharge")
                .hasFieldOrProperty("totalAmount")
                .hasFieldOrProperty("discount");

//        Assert.assertEquals(invoice.getIdInvoice(), invoiceResponseDto.getIdInvoice());
//        Assert.assertEquals(invoice.getQuantityMenu(), invoiceResponseDto.getQuantityMenu());
//        Assert.assertEquals(invoice.getNameMenu(), invoiceResponseDto.getNameMenu());
//        Assert.assertEquals(invoice.getIdOrder(), invoiceResponseDto.getIdOrder());
//        Assert.assertEquals(invoice.getIdTable(), invoiceResponseDto.getIdTable());
//        Assert.assertEquals(invoice.getNumberTable(), invoiceResponseDto.getNumberTable());
    }

    @Test
    public void doPayment() {
        InvoiceRequestDto invoiceRequestDto = new InvoiceRequestDto();

        Integer idOrder = 1;
        Integer idTable = 1;

        invoiceRequestDto.setIdOrder(idOrder);
        invoiceRequestDto.setIdTable(idTable);

//        InvoiceResponseDto invoiceResponseDto = invoiceService.showOrder(invoiceRequestDto);
//        assertThat(invoiceResponseDto.getIdOrder()).isEqualTo(idOrder);
//        assertThat(invoiceResponseDto.getIdTable()).isEqualTo(idTable);
    }

    @Test(expected = IdNotFoundException.class)
    public void failedById() {
        Integer id = 50;
        Invoice invoice = invoiceService.findById(id);
        assertThat(invoice.getIdInvoice()).isNotEqualTo(id);
    }
}
