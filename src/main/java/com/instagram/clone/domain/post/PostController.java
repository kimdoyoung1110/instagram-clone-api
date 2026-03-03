package com.instagram.clone.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public String createPost(@RequestBody PostCreateRequest request) {
        Long postId = postService.createPost(request);
        return "게시물 생성 완료! ID: " + postId;
    }
    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    // 1. 게시물 수정 API
    // 주소 뒤에 /1 처럼 게시물 ID를 받기 위해 @PathVariable을 씁니다.
    @PutMapping("/{postId}")
    public String updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.updatePost(postId, request);
        return "게시물 수정 완료! ID: " + postId;
    }

    // 2. 게시물 삭제 API
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "게시물 삭제 완료! ID: " + postId;
    }
}