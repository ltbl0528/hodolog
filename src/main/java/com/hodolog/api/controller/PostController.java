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
     *
     * 만약 클라단에서 POST 요청에 대한 응답으로 JSON 형태로 내려주세요~ 한다면
     * 1. 저장한 데이터 Entity -> response로 응답하기
     * 2. 저장한 데이터의 primary id -> response로 응답하기
     *                                클라에서는 수신한 id를 글 조회 API를 통해 글 데이터를 수신받음
     * 3. 응답 필요 없음 -> 클라이언트에서 모든 POST(글) 데이터 CONTEXT를 잘 관리함
     *
     * BAD CASE : 서버단에서 반드시 이렇게 할 겁니다!! 하고 FIX해버리기
     *            - 유연하게 하는 게 좋음(코드를 잘 짜자)!
     *            - 한 번에 일괄적으로 잘 처리되는 케이스는 없다.
     *            - 잘 관리하는 형태가 중요하다...
     * */

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        // POST -> 200, 201
        postService.write(request);
    }
}
