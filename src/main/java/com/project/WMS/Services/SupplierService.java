package com.project.WMS.Services;

import com.project.WMS.Dtos.SupplierDTO;
import com.project.WMS.Entities.Supplier;

import java.util.List;

public interface SupplierService {
    void createSupplier(SupplierDTO supplierDTO);
    SupplierDTO findByName(String name);
    List<Supplier>getSuppliers();
    void updateSupplier(long id, SupplierDTO supplier);
    void deleteById(long id);
}