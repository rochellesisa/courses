package com.course.ro.section4.exception;

import com.course.ro.section4.model.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RestResponse> handleApplicationException(ApplicationException ex){
        RestResponse res = new RestResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, false);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<RestResponse> handleValidationException(ValidationException ex){
        RestResponse res = new RestResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, false);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<RestResponse> handleGenericException(MethodArgumentTypeMismatchException ex){
        RestResponse res = new RestResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, false);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<RestResponse> handleGenericException(Exception ex){
        ex.printStackTrace();
        RestResponse res = new RestResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, false);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
