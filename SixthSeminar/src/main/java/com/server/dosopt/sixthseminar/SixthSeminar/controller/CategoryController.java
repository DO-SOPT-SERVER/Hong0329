package com.server.dosopt.sixthseminar.SixthSeminar.controller;

import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.CategoryCreateRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryCreateRequest request){
        URI location = URI.create("/api/post/" + categoryService.createCategory(request));
        return ResponseEntity.created(location).build();
    }
}
