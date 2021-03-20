package com.example.userservice.exceptionhandler;

import static java.util.Collections.singletonMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.userservice.model.utils.ErrorMessage;
import com.example.userservice.model.utils.ResponseWrapper;
import com.example.userservice.model.utils.RestErrorList;

@ControllerAdvice
@EnableWebMvc
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * handleException - Handles all the Exception recieving a request, responseWrapper.
     *@param request
     *@param responseWrapper
     *@return ResponseEntity<ResponseWrapper>
     * @user ihuaylupo
     * @since 2018-09-12
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { Exception.class })
    public @ResponseBody ResponseEntity<ResponseWrapper> handleException(HttpServletRequest request,
                                                                         ResponseWrapper responseWrapper){

        return ResponseEntity.ok(responseWrapper);
    }

    /**
     * handleIOException - Handles all the Authentication Exceptions of the application.
     *@param request
     *@param exception
     *@return ResponseEntity<ResponseWrapper>
     * @user ihuaylupo
     * @since 2018-09-12
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseWrapper> handleIOException(HttpServletRequest request, RuntimeException e){

        RestErrorList errorList = new RestErrorList(HttpStatus.NOT_ACCEPTABLE, new ErrorMessage(e.getMessage(), e.getMessage()));
        ResponseWrapper responseWrapper = new ResponseWrapper(null, singletonMap("status", HttpStatus.NOT_ACCEPTABLE), errorList);


        return ResponseEntity.ok(responseWrapper);
    }
}
