package com.api.resto.pop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class InvoiceRequestDto {

    @PositiveOrZero
    @NotNull
    private Integer idOrder;

    @PositiveOrZero
    @NotNull
    private Integer idTable;
}
