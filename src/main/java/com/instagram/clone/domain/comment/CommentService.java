package com.instagram.clone.domain.comment;

import com.instagram.clone.domain.member.Member;
import com.instagram.clone.domain.member.MemberRepository;
import com.instagram.clone.domain.post.Post;
import com.instagram.clone.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    // 1. 댓글 작성
    @Transactional
    public Long createComment(Long postId, CommentCreateRequest request) {
        // 유저와 게시물이 있는지 확인!
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        // 댓글 생성
        Comment comment = Comment.builder()
                .member(member)
                .post(post)
                .content(request.getContent())
                .build();

        return commentRepository.save(comment).getId();
    }

    // 2. 특정 게시물의 댓글만 조회
    @Transactional(readOnly = true)
    public List<CommentResponse> getComments(Long postId) {
        return commentRepository.findByPostId(postId).stream()
                .map(CommentResponse::new)
                .toList();
    }
}