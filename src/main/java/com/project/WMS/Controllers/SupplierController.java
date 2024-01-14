package com.project.WMS.Controllers;

import com.project.WMS.Dtos.SupplierDTO;
import com.project.WMS.Entities.Supplier;
import com.project.WMS.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/supplier")
    public ResponseEntity<String> createSupplier(@RequestBody SupplierDTO supplierDTO){
        try {
            supplierService.createSupplier(supplierDTO);
            return ResponseEntity.ok("Proveedor creado exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }

    @GetMapping("/suppliers")
    public ResponseEntity getSuppliers(){
        try {
            return ResponseEntity.ok(supplierService.getSuppliers());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
    @GetMapping("/supplier")
    public ResponseEntity getSupplierByName(@RequestParam String name){
        try {
            SupplierDTO supplierDTO = supplierService.findByName(name);
            return ResponseEntity.ok(supplierDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }

    @PutMapping("/supplier/{id}")
    public ResponseEntity updateSupplier(@PathVariable long id, @RequestBody SupplierDTO supplierDTO){
        try {
            supplierService.updateSupplier(id, supplierDTO);
            return ResponseEntity.ok("Proveedor actualizado exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
    @DeleteMapping("/supplier/{id}")
    public ResponseEntity deleteSupplier(@PathVariable long id){
        try {
            supplierService.deleteById(id);
            return ResponseEntity.ok("Proveedor eliminado exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
}