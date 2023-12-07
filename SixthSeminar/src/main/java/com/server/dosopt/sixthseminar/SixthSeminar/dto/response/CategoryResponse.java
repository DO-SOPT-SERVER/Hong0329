package com.server.dosopt.sixthseminar.SixthSeminar.dto.response;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Category;

public record CategoryResponse(
        short id,
        String content
){
    public static CategoryResponse of(Category category) {
        return new CategoryResponse(category.getId(), category.getContent());
    }
//    public static CategoryResponse of(Category category){
//        return new CategoryResponse(category.getContent());
//
//    }
}
