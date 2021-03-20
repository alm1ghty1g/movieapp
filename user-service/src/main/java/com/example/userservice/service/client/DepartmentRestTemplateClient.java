package com.example.userservice.service.client;

import com.example.userservice.model.DepartmentEntity;


import com.example.userservice.repository.DepartmentRedisRepository;
import com.example.userservice.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DepartmentRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DepartmentRedisRepository redisRepository;

    private static final Logger logger = LoggerFactory.getLogger(DepartmentRestTemplateClient.class);


    public DepartmentEntity getDepartment(int  departmentId) {
        logger.debug("In User Service.getDepartmentEntity: {}", UserContext.getCorrelationId());

        DepartmentEntity departmentEntity = checkRedisCache(departmentId);

        if (departmentEntity != null) {
            logger.debug("I have successfully retrieved an departmentEntity {} from the redis cache: {}", departmentId, departmentEntity);
            return departmentEntity;
        }
        logger.debug("Unable to locate departmentEntity from the redis cache: {}.", departmentId);
        ResponseEntity<DepartmentEntity> restExchange =
                restTemplate.exchange(
                        "http://gateway:8072/department/find/{departmentId}",
                        HttpMethod.GET,
                        null, DepartmentEntity.class, departmentId);

        departmentEntity = restExchange.getBody();
        if (departmentEntity != null){
            cacheDepartmentObject(departmentEntity);
        }

        return restExchange.getBody();
    }


    private DepartmentEntity checkRedisCache(int departmentId) {
        try {
            return redisRepository.findById(departmentId).orElse(null);
        }catch (Exception ex){
            logger.error("Error encountered while trying to retrieve DepartmentEntity {} check Redis Cache.  Exception {}", departmentId, ex);
            return null;
        }
    }

    private void cacheDepartmentObject(DepartmentEntity departmentEntity) {
        try {
            redisRepository.save(departmentEntity);
        }catch (Exception ex){
            logger.error("Unable to cache departmentEntity {} in Redis. Exception {}", departmentEntity.getDepartmentId(), ex);
        }
    }

    //    public DepartmentEntity getDepartment(int departmentId){
//        ResponseEntity<DepartmentEntity> restExchange =
//                restTemplate.exchange(
//                        "http://department-service/department/find/{id}",
//                        HttpMethod.GET,
//                        null, DepartmentEntity.class, departmentId);
//
//        return restExchange.getBody();
//    }

}
