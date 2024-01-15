package com.project.WMS.Repositories;

import com.project.WMS.Dtos.SupplierDTO;
import com.project.WMS.Entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "select * from \"SUPPLIER\" s where s.\"NAME\" = :name\n", nativeQuery = true)
    Supplier findByNameIgnoreCase(@Param("name") String name);
}