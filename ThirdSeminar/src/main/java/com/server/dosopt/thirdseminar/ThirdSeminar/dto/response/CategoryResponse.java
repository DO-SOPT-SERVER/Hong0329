package com.server.dosopt.thirdseminar.ThirdSeminar.dto.response;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Category;

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
