package com.api.resto.pop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Floor")
    private Integer idFloor;

    @Column(name = "floor")
    private String floor;

}
