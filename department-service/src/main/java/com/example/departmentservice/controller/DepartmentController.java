package com.example.departmentservice.controller;


import com.example.departmentservice.entity.DepartmentEntity;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity departmentEntity){

        return ResponseEntity.ok(departmentService.saveDepartment(departmentEntity));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DepartmentEntity> findDepartment(@PathVariable int id) {

        return ResponseEntity.ok(departmentService.findDepartment(id));
    }


}
