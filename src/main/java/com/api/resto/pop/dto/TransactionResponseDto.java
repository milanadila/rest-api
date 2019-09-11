package com.api.resto.pop.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class TransactionResponseDto {

    private Integer idTransaction;

    private Collection allOrder;

    private BigDecimal totalAmount;

    private BigDecimal cash;

    private BigDecimal change;
}
