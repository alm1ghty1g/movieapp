package com.example.departmentservice.repository;

import com.example.departmentservice.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

    DepartmentEntity findById(int id);
}
