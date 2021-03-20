package com.example.userservice.events.handler;

import com.example.userservice.events.CustomChannels;
import com.example.userservice.events.model.DepartmentChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CustomChannels.class)
public class DepartmentChangeHandler {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentChangeHandler.class);

    @StreamListener("inboundOrgChanges")
    public void loggerSink(DepartmentChangeModel department) {

        logger.debug("Received a message of type " + department.getType());

        switch(department.getAction()){
            case "GET":
                logger.debug("Received a GET event from the organization service for organization id {}", department.getDepartmentId());
                break;
            case "SAVE":
                logger.debug("Received a SAVE event from the organization service for organization id {}", department.getDepartmentId());
                break;
            case "UPDATE":
                logger.debug("Received a UPDATE event from the organization service for organization id {}", department.getDepartmentId());
                break;
            case "DELETE":
                logger.debug("Received a DELETE event from the organization service for organization id {}", department.getDepartmentId());
                break;
            default:
                logger.error("Received an UNKNOWN event from the organization service of type {}", department.getType());
                break;
        }
    }
}
