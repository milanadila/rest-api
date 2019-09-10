package com.api.resto.pop.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class InvoiceResponseDto {

    private Integer idInvoice;

    private Collection allOrder;

//    private Integer idOrder;
//
    private Integer idTable;
//
    private Integer numberTable;
//
//    private String nameMenu;
//
//    private BigDecimal priceMenu;
//
//    private Integer quantityMenu;

    private Integer totalQty;

    private BigDecimal subTotal;

    private BigDecimal tax;

    private BigDecimal serviceCharge;

    private BigDecimal discount;

    private BigDecimal totalAmount;
}
