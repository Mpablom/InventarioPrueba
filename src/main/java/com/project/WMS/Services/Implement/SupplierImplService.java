package com.project.WMS.Services.Implement;

import com.project.WMS.Dtos.SupplierDTO;
import com.project.WMS.Entities.Supplier;
import com.project.WMS.Repositories.SupplierRepository;
import com.project.WMS.Services.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierImplService implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Autowired
    public SupplierImplService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void createSupplier(SupplierDTO supplierDTO){
        if (supplierDTO == null) {
            throw new IllegalArgumentException("SupplierDTO no puede ser nulo");
        }

        String supplierName = supplierDTO.getName();
        if (supplierName == null || supplierName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proveedor no puede ser nulo o vacío");
        }

        Supplier existingSupplier = supplierRepository.findByName(supplierName);
        if (existingSupplier != null) {
            throw new IllegalArgumentException("Ya existe un proveedor con el nombre: " + supplierName);
        }

        try {
            Supplier supplier = new Supplier();
            BeanUtils.copyProperties(supplierDTO, supplier);
            supplierRepository.save(supplier);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el proveedor", e);
        }
    }
}