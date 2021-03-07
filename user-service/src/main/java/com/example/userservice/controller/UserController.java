package com.example.userservice.controller;

import com.example.userservice.UserEntity.UserEntity;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity){
        System.out.println("saveUser called");
        return ResponseEntity.ok(userService.saveUser(userEntity));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> findUser(@PathVariable int id){
        System.out.println("findUser called");
        return ResponseEntity.ok(userService.findUser(id));
    }


}
