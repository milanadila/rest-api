package com.api.resto.pop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuResponseDto {

    private String nameMenu;

    private BigDecimal priceMenu;
}
