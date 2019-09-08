package com.api.resto.pop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class TransactionRequestDto {

    @PositiveOrZero
    @NotNull
    private Integer idInvoice;

    @PositiveOrZero
    @NotNull
    private BigDecimal cash;
}
