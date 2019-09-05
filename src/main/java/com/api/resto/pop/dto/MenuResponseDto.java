package com.api.resto.pop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuResponseDto {

    private Integer idMenu;

    private String nameMenu;

    private BigDecimal priceMenu;
}
