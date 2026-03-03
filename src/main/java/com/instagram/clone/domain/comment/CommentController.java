package com.instagram.clone.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping
    public String createComment(@PathVariable Long postId, @RequestBody CommentCreateRequest request) {
        Long commentId = commentService.createComment(postId, request);
        return "댓글 작성 완료! ID: " + commentId;
    }

    // 특정 게시물의 댓글 목록 조회
    @GetMapping
    public List<CommentResponse> getComments(@PathVariable Long postId) {
        return commentService.getComments(postId);
    }
}