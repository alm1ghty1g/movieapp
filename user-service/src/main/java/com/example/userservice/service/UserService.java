package com.example.userservice.service;

import com.example.userservice.model.UserEntity;
import com.example.userservice.VO.ResponseTemplateVO;

import java.util.concurrent.TimeoutException;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    UserEntity findUser(int id) throws TimeoutException;

    ResponseTemplateVO getUserWithDepartment(int userId);
}
