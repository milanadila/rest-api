package com.api.resto.pop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class TransactionInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Transaction")
    private Integer idTransaction;

    @Column(name = "Id_Table")
    private Integer idTable;

    @Column(name = "Total_Amount")
    private BigDecimal totalAmount;

    @Column(name = "Cash")
    private BigDecimal cash;

    @Column(name = "Change")
    private BigDecimal change;
}
