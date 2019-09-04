package com.api.resto.pop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponseDto {

    private Integer idOrder;

    private Integer idTable;

    private Integer numberTable;

    private Integer idMenu;

    private String nameMenu;

    private BigDecimal priceMenu;

    private Integer quantityMenu;
}
