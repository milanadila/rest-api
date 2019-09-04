package com.api.resto.pop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TableOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Table")
    private Integer idTable;

    @Column(name = "Number_Table")
    private Integer numberTable;
}
