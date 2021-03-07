package com.example.userservice.repository;

import com.example.userservice.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findById(int id);

}
