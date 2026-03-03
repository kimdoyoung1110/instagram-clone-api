package com.instagram.clone.domain.post;

import lombok.Getter;

@Getter
public class PostResponse {
    private Long id;
    private String username; // 누가 썼는지 (Member에서 가져옴!)
    private String content;  // 본문
    private String imageUrl; // 이미지

    // Post 엔티티를 받아서 DTO로 변환해주는 마법의 생성자
    public PostResponse(Post post) {
        this.id = post.getId();
        this.username = post.getMember().getUsername(); // 연관관계 덕분에 이렇게 바로 유저 이름을 꺼낼 수 있어요!
        this.content = post.getContent();
        this.imageUrl = post.getImageUrl();
    }
}