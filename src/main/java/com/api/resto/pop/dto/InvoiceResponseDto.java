package com.api.resto.pop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceResponseDto {

    private Integer idInvoice;

    private Integer idOrder;

    private Integer idTable;

    private Integer numberTable;

    private String nameMenu;

    private BigDecimal priceMenu;

    private Integer quantityMenu;

    private BigDecimal subTotal;

    private BigDecimal tax;

    private BigDecimal serviceCharge;

    private BigDecimal discount;

    private BigDecimal totalAmount;
}
