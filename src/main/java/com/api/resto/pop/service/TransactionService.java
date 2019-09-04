package com.api.resto.pop.service;

import com.api.resto.pop.dto.TransactionRequestDto;
import com.api.resto.pop.dto.TransactionResponseDto;
import com.api.resto.pop.entity.Invoice;
import com.api.resto.pop.entity.TransactionInvoice;
import com.api.resto.pop.exception.IdNotFoundException;
import com.api.resto.pop.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    InvoiceService invoiceService;

    public List<TransactionInvoice> findAll() {
        return transactionRepository.findAll();
    }

    public TransactionInvoice findById(Integer id) {
        return transactionRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    public TransactionResponseDto doTransaction(TransactionRequestDto transactionRequestDto) {

        Invoice invoice = invoiceService.findByIdInvoice(transactionRequestDto.getIdInvoice());
        Integer getIdInvoice = invoice.getIdInvoice();
        BigDecimal totalAmount = invoice.getTotalAmount();

        TransactionInvoice transactionInvoice = new TransactionInvoice();
        transactionInvoice.setIdInvoice(transactionRequestDto.getIdInvoice());
        transactionInvoice.setCash(transactionRequestDto.getCash());
        transactionInvoice.setTotalAmount(totalAmount);
        transactionRepository.save(transactionInvoice);

        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setIdTransaction(transactionInvoice.getIdTransaction());
        transactionResponseDto.setIdInvoice(getIdInvoice);
        transactionResponseDto.setTotalAmount(totalAmount);
        transactionResponseDto.setCash(transactionInvoice.getCash());
        transactionResponseDto.setChange(transactionInvoice.getCash().subtract(totalAmount));

        return transactionResponseDto;
    }
}
