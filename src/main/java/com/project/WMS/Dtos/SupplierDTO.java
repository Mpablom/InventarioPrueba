package com.project.WMS.Dtos;

import com.project.WMS.Entities.Product;
import com.project.WMS.Entities.SupplierProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SupplierDTO {
    private String name;
    private String address;
    private String contact;
    private List<SupplierProduct> suppliedProducts;
}