package com.server.dosopt.thirdseminar.ThirdSeminar.dto.response;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Category;
import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Post;


public record PostGetResponse(
        Long id,
        String title,
        String content,
        String category
        ) {
    public static PostGetResponse of(Post post,Category category) {
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                category.getContent()
                );
    }
}
