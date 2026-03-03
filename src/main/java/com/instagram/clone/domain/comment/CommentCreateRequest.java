package com.instagram.clone.domain.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentCreateRequest {
    private Long memberId; // 누가 쓰는지
    private String content; // 댓글 내용
    // postId는 주소창(/api/posts/1/comments)에서 받을 거라 여기에 안 넣습니다!
}