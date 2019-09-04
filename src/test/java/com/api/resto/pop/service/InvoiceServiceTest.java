package com.api.resto.pop.service;

import com.api.resto.pop.dto.InvoiceRequestDto;
import com.api.resto.pop.dto.InvoiceResponseDto;
import com.api.resto.pop.entity.Invoice;
import lombok.extern.slf4j.Slf4j;
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

    @Test
    public void findAll() {
        List<Invoice> invoiceResponseDtoTest = invoiceService.findAll();
        assertThat(invoiceResponseDtoTest.size()).isNotNull();
        for (int i = 0; i < invoiceResponseDtoTest.size(); i++) {
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
    }

    @Test
    public void doPayment() {
        InvoiceRequestDto invoiceRequestDto = new InvoiceRequestDto();

        Integer idOrder = 1;
        Integer idTable = 1;

        invoiceRequestDto.setIdOrder(idOrder);
        invoiceRequestDto.setIdTable(idTable);

        InvoiceResponseDto invoiceResponseDto = invoiceService.doPayment(invoiceRequestDto);
        assertThat(invoiceResponseDto.getIdOrder()).isEqualTo(idOrder);
        assertThat(invoiceResponseDto.getIdTable()).isEqualTo(idTable);
    }
}
