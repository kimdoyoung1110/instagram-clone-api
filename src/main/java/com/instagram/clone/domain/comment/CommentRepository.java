package com.instagram.clone.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 마법의 메서드: "Post ID가 ?인 댓글들만 다 찾아줘!"
    List<Comment> findByPostId(Long postId);
}