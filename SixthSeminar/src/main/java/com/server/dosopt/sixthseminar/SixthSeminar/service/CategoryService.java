package com.server.dosopt.sixthseminar.SixthSeminar.service;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Category;
import com.server.dosopt.sixthseminar.SixthSeminar.domain.CategoryId;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.CategoryCreateRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.response.CategoryResponse;
import com.server.dosopt.sixthseminar.SixthSeminar.repository.CategoryJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public Category getByCategoryId(CategoryId categoryId) {
        return categoryJpaRepository.findById(Short.valueOf(categoryId.getCategoryId())).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
    }

    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다.")));
    }

    @Transactional
    public String createCategory(CategoryCreateRequest request){
        Category category = categoryJpaRepository.save(Category.builder()
                .content(request.name())
                .build()
        );
        return category.getContent().toString();
    }
}
