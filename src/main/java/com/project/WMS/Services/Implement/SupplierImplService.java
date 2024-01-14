package com.project.WMS.Services.Implement;

import com.project.WMS.Dtos.SupplierDTO;
import com.project.WMS.Entities.Supplier;
import com.project.WMS.Repositories.SupplierRepository;
import com.project.WMS.Services.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierImplService implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Autowired
    public SupplierImplService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void createSupplier(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            throw new IllegalArgumentException("El proveedor no puede estar vacío");
        }

        String supplierName = supplierDTO.getName();
        if (supplierName == null || supplierName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proveedor no puede ser nulo o vacío");
        }

        SupplierDTO existingSupplier = supplierRepository.findByName(supplierName);
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
    @Override
    public SupplierDTO findByName(String name) {
        SupplierDTO supplierDTO = supplierRepository.findByName(name);
        if (supplierDTO != null) {
            return supplierDTO;
        } else {
            throw new EntityNotFoundException("Proveedor no encontrado con el nombre: " + name);
        }
    }

    @Override
    public List<Supplier>getSuppliers() {
        return supplierRepository.findAll();
    }
    @Override
    public SupplierDTO updateSupplier(long id, SupplierDTO supplierDTO) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);

        if (optionalSupplier.isEmpty()) {
            throw new IllegalArgumentException("No existe un proveedor con el id: " + id);
        }

        Supplier existingSupplier = optionalSupplier.get();

        existingSupplier.setContact(supplierDTO.getContact());
        existingSupplier.setName(supplierDTO.getName());
        existingSupplier.setBusiness(supplierDTO.getBusiness());

        Supplier updatedSupplier = supplierRepository.save(existingSupplier);

        SupplierDTO updatedSupplierDTO = new SupplierDTO();
        BeanUtils.copyProperties(updatedSupplier, updatedSupplierDTO);
        return updatedSupplierDTO;
    }
    @Override
    public void deleteById(long id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isEmpty()) {
            throw new IllegalArgumentException("No existe un proveedor con el id: " + id);
        }
        supplierRepository.deleteById(id);
    }
}