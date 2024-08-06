package com.hodolog.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     *
     * GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT
     *
     * 글 등록
     * POST METHOD
     *
     * */
    @PostMapping("/posts")
//    public String post(@RequestParam String title, @RequestParam String content) {
    public String post(@RequestParam Map<String, String> params) {
        log.info("params={}", params.toString());
        return "Hello World";
    }
}
