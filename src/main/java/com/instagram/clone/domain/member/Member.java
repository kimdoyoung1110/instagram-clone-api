package com.instagram.clone.domain.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // 인스타 아이디 (예: dozero)

    @Column(nullable = false)
    private String password; // 비밀번호

    private String name; // 실제 이름

    // 원래는 S3 복합 객체였지만, 지금은 간단하게 URL 문자열로 처리합니다.
    private String profileImageUrl;

    @Builder
    public Member(String username, String password, String name, String profileImageUrl) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
}