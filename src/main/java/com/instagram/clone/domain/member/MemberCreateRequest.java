package com.instagram.clone.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter // postman에서 받아온 데이터를 받아주는 역할
@NoArgsConstructor // 기본 생성자
public class MemberCreateRequest {
    private String username;
    private String password;
    private String name;
}