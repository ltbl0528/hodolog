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


/**
 * <pre>Exception을 처리하는 클래스</pre>
 * <li> 예외를 어떤 어노테이션으로 어떻게 핸들링 하는가를 배워보자!</li>
 * <li> ControllerAdvice, ExceptionHandler, ResponseBody </li>
 * */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
//        if (e.hasErrors()) {
           ErrorResponse response = ErrorResponse.builder()
                   .code("400")
                   .message("잘못된 요청입니다.")
                   .build();

           for (FieldError filedError : e.getFieldErrors()) {
               response.addValidation(filedError.getField(), filedError.getDefaultMessage());
           }
//        } else { // 에러가 없는 게 발생할 수 있는 거임?
//
//        }
        return response;
    }
}
