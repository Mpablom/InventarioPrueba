package com.project.WMS.Repositories;

import com.project.WMS.Dtos.SupplierDTO;
import com.project.WMS.Entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "SELECT * FROM \"SUPPLIER\" s where s.\"NAME\" = :\"name\"\n", nativeQuery = true)
    SupplierDTO findByName(String name);
}