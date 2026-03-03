package com.instagram.clone.domain.like;

import com.instagram.clone.domain.member.Member;
import com.instagram.clone.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    // 유저와 게시물 정보로 좋아요 기록 찾기
    Optional<PostLike> findByMemberAndPost(Member member, Post post);
}