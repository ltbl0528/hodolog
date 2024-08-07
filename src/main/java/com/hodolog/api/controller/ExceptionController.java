package com.hodolog.api.controller;

import com.hodolog.api.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>Exception을 처리하는 클래스</pre>
 * <li> 예외를 어떤 어노테이션으로 어떻게 핸들링 하는가를 배워보자!</li>
 * <li> ControllerAdvice, ExceptionHandler, ResponseBody </li>
 * */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
//        FieldError fieldError = e.getFieldError();
//        String field = fieldError.getField();
//        String message = fieldError.getDefaultMessage();
//        Map<String, String> response = new HashMap<>();
//        response.put(field, message);
//        return response;

//        if (e.hasErrors()) {
           ErrorResponse response = new ErrorResponse("400", "잘못된 요청입니다.");

           for (FieldError filedError : e.getFieldErrors()) {
               response.addValidation(filedError.getField(), filedError.getDefaultMessage());
           }

//        } else { // 에러가 없는 게 발생할 수 있는 거임?
//
//        }
        return response;
    }
}
