package com.instagram.clone.domain.post;

import com.instagram.clone.domain.member.Member;
import com.instagram.clone.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long createPost(PostCreateRequest request) {
        // 1. 작성자(Member) 조회
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        // 2. 게시물(Post) 생성 및 저장
        Post post = Post.builder()
                .member(member)
                .content(request.getContent())
                .imageUrl(request.getImageUrl())
                .build();

        return postRepository.save(post).getId();
    }
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        // 1. DB에서 모든 게시물을 다 꺼내온다
        // 2. Post 엔티티들을 PostResponse DTO로 싹 변환해서 리스트로 반환한다
        return postRepository.findAll().stream()
                .map(PostResponse::new)
                .toList();
    }

    // 1. 게시물 수정 (Update)
    @Transactional
    public Long updatePost(Long postId, PostUpdateRequest request) {
        // DB에서 수정할 게시물을 찾는다.
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        // 엔티티의 내용을 바꾼다. (JPA가 알아서 DB에 UPDATE 쿼리를 날려줍니다! = 더티 체킹)
        post.update(request.getContent(), request.getImageUrl());

        return post.getId();
    }

    // 2. 게시물 삭제 (Delete)
    @Transactional
    public void deletePost(Long postId) {
        // DB에서 삭제할 게시물을 찾는다.
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));

        // DB에서 아예 지워버린다.
        postRepository.delete(post);
    }
}