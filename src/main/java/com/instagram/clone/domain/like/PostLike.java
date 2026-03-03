package com.instagram.clone.domain.like;

import com.instagram.clone.domain.member.Member;
import com.instagram.clone.domain.post.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLike {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 좋아요 누른 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post; // 좋아요가 달린 게시물

    @Builder
    public PostLike(Member member, Post post) {
        this.member = member;
        this.post = post;
    }
}