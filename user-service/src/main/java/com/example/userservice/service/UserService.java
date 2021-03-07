package com.example.userservice.service;

import com.example.userservice.UserEntity.UserEntity;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    UserEntity findUser(int id);

}
