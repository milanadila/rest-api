package com.api.resto.pop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InvoiceRequestDto {

    @NotNull
    private Integer idOrder;

    @NotNull
    private Integer idTable;
}
