package com.instagram.clone.domain.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostUpdateRequest {
    private String content;
    private String imageUrl;
}