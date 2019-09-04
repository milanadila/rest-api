package com.api.resto.pop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionResponseDto {

    private Integer idTransaction;

    private Integer idInvoice;

    private BigDecimal totalAmount;

    private BigDecimal cash;

    private BigDecimal change;
}
