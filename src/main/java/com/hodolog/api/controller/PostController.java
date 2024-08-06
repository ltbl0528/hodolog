package com.hodolog.api.controller;

import com.hodolog.api.request.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 데이터 기반 API 응답을 생성
@Slf4j
@RestController
public class PostController {

    // SSR -> JSP, thymeleaf, mustache, freemarker
    //        // -> html rendering (서버에서 렌더링 후 데이터를 내려줌)
    // SPA -> vue
    //        // -> javascript(화면) <-> API (서버와의 통신은 API(JSON)로만)
    //   vue -> vue + SSR = nuxt.js
    //   react -> react + SSR = next.js

    /**
     * HTTP METHOD
     * ㄴ> GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT
     * 글 등록
     * POST METHOD
     * */
    @PostMapping("/posts")
//    public String post(@RequestParam String title, @RequestParam String content) {
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result) {
        /**
         * 데이터를 검증하는 이유
         * 1. client 개발자가 값을 깜빡할 수 있다. (실수)
         * 2. client bug로 값이 누락될 수 있다.
         * 3. 외부에 나쁜 사람이 값을 임의로 조작할 수 있다.
         * 4. DB에 값을 저장할 때 의도치 않은 오류가 발생할 수 있다.
         * 5. 서버 개발자의 편안함을 위해
         *
         * 때마다 null check, empty string check를 할 수도 있겠지만 Spring에서 제공하는 어노테이션을 쓰자...
         * */

        /**
         * TODO: 여전히 해결해야 하는 문제점들이 있다... EX.매 메소드마다 이런 처리를 해줘야하는가에 대한
         * ==> EXCEPTION에 대한 일괄처리가 가능하게끔 코드 변경이 필요하다
         * */
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField(); // title
            String errMsg    = firstFieldError.getDefaultMessage(); // error message

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errMsg);
            return error;
        }
        log.info("params={}", params.toString());

        return Map.of();
    }
}
