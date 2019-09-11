//package com.api.resto.pop.service;
//
//import com.api.resto.pop.dto.TransactionRequestDto;
//import com.api.resto.pop.dto.TransactionResponseDto;
//import com.api.resto.pop.entity.TransactionInvoice;
//import com.api.resto.pop.exception.IdNotFoundException;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//
//import java.math.BigDecimal;
//import java.util.List;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@Slf4j
//public class TransactionServiceTest {
//
//    @Autowired
//    TransactionService transactionService;
//
//    @Test
//    public void findAll() {
//        List<TransactionInvoice> transactionTest = transactionService.findAll();
//        assertThat(transactionTest.size()).isNotNull();
//        for (int i = 0; i < transactionTest.size(); i++) {
//        }
//    }
//
//    @Test
//    public void findById() {
//        Integer id = 1;
//        TransactionInvoice transactionInvoice = transactionService.findById(id);
//
//        assertThat(transactionInvoice)
//                .hasFieldOrProperty("idTransaction")
//                .hasFieldOrProperty("idInvoice")
//                .hasFieldOrProperty("totalAmount")
//                .hasFieldOrProperty("cash")
//                .hasFieldOrProperty("change");
//    }
//
//    @Test
//    public void doTransaction() {
//        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
//
//        BigDecimal cash = BigDecimal.valueOf(200000);
//        Integer idInvoice = 1;
//
//        transactionRequestDto.setCash(cash);
//        transactionRequestDto.setIdInvoice(idInvoice);
//
//        TransactionResponseDto transactionResponseDto = transactionService.doTransaction(transactionRequestDto);
//        assertThat(transactionResponseDto.getCash()).isEqualTo(cash);
//        assertThat(transactionResponseDto.getIdInvoice()).isEqualTo(idInvoice);
//    }
//
//    @Test(expected = IdNotFoundException.class)
//    public void failedById() {
//        Integer id = 50;
//        TransactionInvoice transactionInvoice = transactionService.findById(id);
//        assertThat(transactionInvoice.getIdTransaction()).isNotEqualTo(id);
//    }
//}
