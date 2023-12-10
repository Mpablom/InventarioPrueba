package com.project.WMS.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long codeProduct;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "STOCK")
    private Integer stock;
}