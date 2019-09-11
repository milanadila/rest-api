package com.api.resto.pop.service;

import com.api.resto.pop.dto.InvoiceResponseDto;
import com.api.resto.pop.dto.TransactionRequestDto;
import com.api.resto.pop.dto.TransactionResponseDto;
import com.api.resto.pop.entity.Invoice;
import com.api.resto.pop.entity.TableOrder;
import com.api.resto.pop.entity.TransactionInvoice;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TableService tableService;

//    @Autowired
//    InvoiceService invoiceService;

    public List<TransactionInvoice> findAll() {
        return transactionRepository.findAll();
    }

    public TransactionInvoice findById(Integer id) {
        return transactionRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }


    InvoiceService x = new InvoiceService();
    HashMap<Integer, InvoiceResponseDto> totalOrders = x.getHashTotal();

    public TransactionResponseDto doTransaction(TransactionRequestDto transactionRequestDto) {
//        TableOrder tableOrder = tableService.findByIdTable(transactionRequestDto.getIdTable());
//        Integer getIdTable = tableOrder.getIdTable();

        TransactionInvoice transactionInvoice = new TransactionInvoice();
        transactionInvoice.setIdTable(transactionRequestDto.getIdTable());
        transactionInvoice.setCash(transactionRequestDto.getCash());
        transactionRepository.save(transactionInvoice);

        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setAllOrder(totalOrders.values());
        BigDecimal getTotalAmount = totalTransaction().getTotalAmount();
        transactionResponseDto.setTotalAmount(getTotalAmount);
        transactionResponseDto.setCash(transactionInvoice.getCash());
        transactionResponseDto.setChange(transactionInvoice.getCash().subtract(getTotalAmount));

        return transactionResponseDto;


//        Invoice invoice = invoiceService.findByIdInvoice(transactionRequestDto.getIdInvoice());
//        Integer getIdInvoice = invoice.getIdInvoice();
//        BigDecimal totalAmount = invoice.getTotalAmount();
//
//        TransactionInvoice transactionInvoice = new TransactionInvoice();
//        transactionInvoice.setIdInvoice(transactionRequestDto.getIdInvoice());
//        transactionInvoice.setCash(transactionRequestDto.getCash());
//        transactionInvoice.setTotalAmount(totalAmount);
//        transactionInvoice.setChange(transactionInvoice.getCash().subtract(totalAmount));
//        transactionRepository.save(transactionInvoice);

//        Invoice invoice = invoiceService.findByIdInvoice(transactionRequestDto.getIdInvoice());
//        Integer getIdInvoice = invoice.getIdInvoice();
//        BigDecimal totalAmount = invoice.getTotalAmount();
//
//        TransactionInvoice transactionInvoice = new TransactionInvoice();
//        transactionInvoice.setIdInvoice(transactionRequestDto.getIdInvoice());
//        transactionInvoice.setCash(transactionRequestDto.getCash());
//        transactionInvoice.setTotalAmount(totalAmount);
//        transactionInvoice.setChange(transactionInvoice.getCash().subtract(totalAmount));
//        transactionRepository.save(transactionInvoice);
//
//        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
//        transactionResponseDto.setIdTransaction(transactionInvoice.getIdTransaction());
//        transactionResponseDto.setIdInvoice(getIdInvoice);
//        transactionResponseDto.setTotalAmount(totalAmount);
//        transactionResponseDto.setCash(transactionInvoice.getCash());
//        transactionResponseDto.setChange(transactionInvoice.getCash().subtract(totalAmount));
//
//        return transactionResponseDto;
    }

    private TransactionResponseDto totalTransaction() {
        TransactionResponseDto transactionResponseDtos = new TransactionResponseDto();

        BigDecimal totalAmount = BigDecimal.valueOf(0);

        HashMap<Integer, InvoiceResponseDto> map = totalOrders;
        for (Map.Entry<Integer, InvoiceResponseDto> x: map.entrySet()) {
            BigDecimal totalAmounts = x.getValue().getTotalAmount();

            totalAmount = totalAmount.add(totalAmounts);
            transactionResponseDtos.setTotalAmount(totalAmount);
        }

        return transactionResponseDtos;
    }
}
