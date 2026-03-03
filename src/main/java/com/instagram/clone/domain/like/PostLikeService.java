package com.instagram.clone.domain.like;

import com.instagram.clone.domain.member.Member;
import com.instagram.clone.domain.member.MemberRepository;
import com.instagram.clone.domain.post.Post;
import com.instagram.clone.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public String toggleLike(Long postId, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        // 이 유저가 이 게시물에 좋아요를 눌렀는지 확인
        Optional<PostLike> existingLike = postLikeRepository.findByMemberAndPost(member, post);

        if (existingLike.isPresent()) {
            // 1. 이미 좋아요를 눌렀다면 -> 삭제 (좋아요 취소)
            postLikeRepository.delete(existingLike.get());
            return "좋아요 취소 완료! 💔";
        } else {
            // 2. 좋아요를 안 눌렀다면 -> 생성 (좋아요 성공)
            PostLike postLike = PostLike.builder()
                    .member(member)
                    .post(post)
                    .build();
            postLikeRepository.save(postLike);
            return "좋아요 성공! ❤️";
        }
    }
}