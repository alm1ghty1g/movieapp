package com.example.departmentservice.events.source;


import com.example.departmentservice.events.model.DepartmentChangeModel;
import com.example.departmentservice.utils.UserContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {

    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);


    @Autowired
    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishDepartmentChange(String action, int departmentId){
        logger.debug("Sending Kafka message {} for Department Id: {}", action, departmentId);
        DepartmentChangeModel change =  new DepartmentChangeModel(
                DepartmentChangeModel.class.getTypeName(),
                action,
                departmentId,
                UserContext.getCorrelationId());

        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
