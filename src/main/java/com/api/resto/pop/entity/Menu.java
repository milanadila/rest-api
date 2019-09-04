package com.api.resto.pop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_menu")
    private Integer idMenu;

    @Column(name = "Name")
    private String nameMenu;

    @Column(name = "Price")
    private BigDecimal priceMenu;

//    @Column(name = "Stock")
//    private Integer stockMenu;
//
//    @Column(name = "Category")
//    private String category;
}
