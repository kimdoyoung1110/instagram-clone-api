package com.instagram.clone.domain.comment;

import lombok.Getter;

@Getter
public class CommentResponse {
    private Long id;
    private String username; // 작성자 이름
    private String content; // 댓글 내용

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getMember().getUsername(); // 유저 테이블에서 이름 쏙 빼오기
        this.content = comment.getContent();
    }
}