package com.instagram.clone.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long createMember(MemberCreateRequest request) {
        Member member = Member.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .name(request.getName())
                .profileImageUrl("default.jpg") // 임시 기본 이미지
                .build();

        return memberRepository.save(member).getId();
    }
}