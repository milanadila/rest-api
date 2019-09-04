package com.api.resto.pop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TransactionRequestDto {

    @NotNull
    private Integer idInvoice;

    @NotNull
    private BigDecimal cash;
}
