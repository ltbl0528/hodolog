package com.hodolog.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 데이터 기반 API 응답을 생성
@RestController
public class PostController {

    // SSR -> JSP, thymeleaf, mustache, freemarker
    //        // -> html rendering (서버에서 렌더링 후 데이터를 내려줌)
    // SPA -> vue
    //        // -> javascript(화면) <-> API (서버와의 통신은 API(JSON)로만)
    //   vue -> vue + SSR = nuxt.js
    //   react -> react + SSR = next.js

    @GetMapping("/posts")
    public String get() {
        return "Hello World";
    }
}
