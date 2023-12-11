package com.project.WMS.Services;

import com.project.WMS.Dtos.SupplierDTO;
import com.project.WMS.Entities.Supplier;

public interface SupplierService {
    void createSupplier(SupplierDTO supplierDTO);
}