package com.hodolog.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostCreate {

    @NotBlank(message = "타이틀을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    /**
     * builder pattern 에 대해 알아보자
     * builder의 장점? :
     * 1. 가독성이 좋다 (값 생성이 유연함)
     * 2. 필요한 값만 받을 수 있다 (오버로딩 가능한 조건을 찾아보세요)ㄴ
     * */
    @Builder
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

