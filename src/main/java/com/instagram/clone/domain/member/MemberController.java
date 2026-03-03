package com.instagram.clone.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public String createMember(@RequestBody MemberCreateRequest request) {
        Long memberId = memberService.createMember(request);
        return "유저 생성 완료! ID: " + memberId;
    }
}