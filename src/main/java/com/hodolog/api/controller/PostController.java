package com.hodolog.api.controller;

import com.hodolog.api.request.PostCreate;
import com.hodolog.api.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 데이터 기반 API 응답을 생성
@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    /**
     * Controller
     * ↓ 호출
     * Service
     * ↓ 호출
     * Repository
     * */
    private final PostService postService;

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate request) {
        postService.write(request);
        return Map.of();
    }
}
