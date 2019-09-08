package com.api.resto.pop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class OrderRequestDto {


    @NotNull
    private Integer idTable;

    @NotNull
    private Integer idMenu;

    @PositiveOrZero
    @NotNull
    private Integer quantityMenu;
}
