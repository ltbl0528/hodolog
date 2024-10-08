package com.hodolog.api.controller;

import com.hodolog.api.request.PostCreate;
import com.hodolog.api.response.PostResponse;
import com.hodolog.api.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * <p>
     * 만약 클라단에서 POST 요청에 대한 응답으로 JSON 형태로 내려주세요~ 한다면
     * 1. 저장한 데이터 Entity -> response로 응답하기
     * 2. 저장한 데이터의 primary id -> response로 응답하기
     * 클라에서는 수신한 id를 글 조회 API를 통해 글 데이터를 수신받음
     * 3. 응답 필요 없음 -> 클라이언트에서 모든 POST(글) 데이터 CONTEXT를 잘 관리함
     * <p>
     * BAD CASE : 서버단에서 반드시 이렇게 할 겁니다!! 하고 FIX해버리기
     * - 유연하게 하는 게 좋음(코드를 잘 짜자)!
     * - 한 번에 일괄적으로 잘 처리되는 케이스는 없다.
     * - 잘 관리하는 형태가 중요하다...
     * <p>
     * <p>
     * // 서비스 정책에 맞는 응답 클래스 분리하기
     * /*
     * ex. 만약에 클라이언트 쪽에서 타이틀을 10자 이내로 잘라주세요... 같은 요청이 온다면
     * (사실 이런 건 클라쪽에서 처리하긴 함)
     * 대충 이런 정책이 있을 경우에 그 정책에 맞는 응답 클래스를 생성하는 게 좋다는 소리임
     */

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        // POST -> 200, 201
        postService.write(request);
    }

    /**
     * /posts -> 글 전체 조회 (검색 + 페이징)
     * /posts/{postId} -> 특정 글 하나만 조회
     */
    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable Long postId) {
        // Request 클래스
        // Response 클래스
        PostResponse response = postService.get(postId);
        return response;
    }

    /**
     * 여러 건의 글 조회 기능
     * /posts
     * [글을 전체 조회 하는 경우]
     * 1. 글이 너무 많을 경우 DB가 뻗을 수 있음
     * 2. DB -> APP 전달 시간, 트래픽 비용 많이 발생
     * TODO: 페이지네이션
     */
    @GetMapping("/posts")
    public List<PostResponse> getList() {
        return postService.getList(1);
    }

}
