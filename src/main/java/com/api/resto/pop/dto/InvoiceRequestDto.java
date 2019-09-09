package com.api.resto.pop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class InvoiceRequestDto {

    @PositiveOrZero
    @NotNull(message = "Id Order Must be Filled")
    private Integer idOrder;

    @PositiveOrZero
    @NotNull(message = "Id Table Must be Filled")
    private Integer idTable;
}
