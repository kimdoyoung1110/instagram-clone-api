package com.instagram.clone.domain.like;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/likes")
public class PostLikeController {

    private final PostLikeService postLikeService;

    // POST /api/posts/1/likes?memberId=1
    @PostMapping
    public String toggleLike(@PathVariable Long postId, @RequestParam Long memberId) {
        return postLikeService.toggleLike(postId, memberId);
    }
}