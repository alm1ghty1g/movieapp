package com.example.userservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;


@Getter @Setter @ToString
@RedisHash("department")
public class DepartmentEntity implements Serializable {

     @Id
     int departmentId;
     String departmentName;
     String departmentLocation;

}
