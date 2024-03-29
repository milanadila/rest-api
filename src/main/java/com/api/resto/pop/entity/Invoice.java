package com.api.resto.pop.entity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity

public class Invoice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Invoice")
    private Integer idInvoice;

    @Column(name = "Id_Table")
    private Integer idTable;

    @Column(name = "Number_Table")
    private Integer numberTable;

    @Column(name = "Id_Order")
    private Integer idOrder;

    @Column(name = "Id_Menu")
    private Integer idMenu;

    @Column(name = "Name_Menu")
    private String nameMenu;

    @Column(name = "Price_Menu")
    private BigDecimal priceMenu;

    @Column(name = "Quantity_Menu")
    private Integer quantityMenu;

    @Column(name = "Sub_Total")
    private BigDecimal subTotal;

    @Column(name = "Tax")
    private BigDecimal tax;

    @Column(name = "Service_Charge")
    private BigDecimal serviceCharge;

    @Column(name = "Discount")
    private BigDecimal discount;

    @Column(name = "Total_Amount")
    private BigDecimal totalAmount;

}
