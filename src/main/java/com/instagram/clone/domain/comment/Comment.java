package com.instagram.clone.domain.comment;

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
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 댓글 작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post; // 댓글이 달린 게시물

    @Column(nullable = false)
    private String content; // 댓글 내용

    @Builder
    public Comment(Member member, Post post, String content) {
        this.member = member;
        this.post = post;
        this.content = content;
    }
}