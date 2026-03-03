package com.instagram.clone.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateRequest {
    private Long memberId; // 누가 작성했는지 식별
    private String content; // 본문 내용
    private String imageUrl; // 이미지 주소(임시 문자열)
}