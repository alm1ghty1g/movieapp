package com.example.userservice.repository;

import com.example.userservice.model.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRedisRepository extends CrudRepository<DepartmentEntity, Integer> {
}
