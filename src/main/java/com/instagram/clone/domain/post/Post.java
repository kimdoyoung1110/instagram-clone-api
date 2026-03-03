package com.instagram.clone.domain.post;

import com.instagram.clone.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 작성자

    @Column(nullable = false)
    private String content; // 본문

    // 원래는 별도의 PostImage 테이블을 뒀지만, 가장 기본부터 하기 위해 게시물당 이미지 1개로 단순화
    private String imageUrl;

    @Builder
    public Post(Member member, String content, String imageUrl) {
        this.member = member;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    // 수정 기능
    public void update(String content, String imageUrl) {
        this.content = content;
        this.imageUrl = imageUrl;
    }

}