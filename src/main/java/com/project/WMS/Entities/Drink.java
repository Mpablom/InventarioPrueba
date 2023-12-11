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
@Table(name = "DRINK")
public class Drink extends Product {
    @Column(name = "TYPE_OF_PACKAGING")
    private String typeOfPackaging;
}