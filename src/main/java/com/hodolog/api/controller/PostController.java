package com.hodolog.api.controller;

import com.hodolog.api.request.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 데이터 기반 API 응답을 생성
@Slf4j // log를 위한 어노테이션
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
    public String post(@RequestBody @Valid PostCreate params, BindingResult result) {
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

        log.info("params={}", params.toString());

        return "Hello World";
    }
}
