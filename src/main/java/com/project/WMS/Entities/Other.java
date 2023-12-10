package com.project.WMS.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "OTHER")
public class Other {
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "BRAND")
    private String brand;
}