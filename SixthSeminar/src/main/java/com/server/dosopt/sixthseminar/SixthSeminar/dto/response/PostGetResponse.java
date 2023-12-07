package com.server.dosopt.sixthseminar.SixthSeminar.dto.response;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Category;
import com.server.dosopt.sixthseminar.SixthSeminar.domain.Post;


public record PostGetResponse(
        Long id,
        String title,
        String content,
        String category
        ) {
    public static PostGetResponse of(Post post, Category category) {
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                category.getContent()
                );
    }
}
