package com.api.resto.pop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class OrderFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Order")
    private Integer idOrder;

    @Column(name = "Id_Table")
    private Integer idTable;

    @Column(name = "Number_Table")
    private Integer numberTable;

    @Column(name = "Id_menu")
    private Integer idMenu;

    @Column(name = "Name_Menu")
    private String nameMenu;

    @Column(name = "Price_Menu")
    private BigDecimal priceMenu;

    @Column(name = "Quantity_Menu")
    private Integer quantityMenu;
}
