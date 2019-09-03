package com.api.resto.pop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderRequestDto {


    @NotNull
    private Integer idTable;

    @NotNull
    private Integer idMenu;

    @NotNull
    private Integer quantityMenu;
}
