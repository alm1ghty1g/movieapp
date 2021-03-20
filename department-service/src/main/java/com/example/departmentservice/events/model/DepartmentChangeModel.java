package com.example.departmentservice.events.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentChangeModel {

    private String type;
    private String action;
    private int departmentId;
    private String correlationId;


    public DepartmentChangeModel(String type, String action, int departmentId, String correlationId) {
        super();
        this.type = type;
        this.action = action;
        this.departmentId = departmentId;
        this.correlationId = correlationId;
    }
}
