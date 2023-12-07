package com.server.dosopt.sixthseminar.SixthSeminar.controller;

import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.PostCreate2Request;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.PostCreateRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.service.PostServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.security.Principal;

@RestController
@RequestMapping("/api/v2/posts")
@RequiredArgsConstructor
public class PostControllerV2 {

    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostServiceV2 postService;

    @PostMapping
    public ResponseEntity<Void> createPostV2(@RequestHeader(CUSTOM_AUTH_ID) Long memberId, @RequestPart MultipartFile image, PostCreateRequest request) {
        URI location = URI.create("/api/posts/v2" + postService.createV2(request, image, memberId));
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<Void> createPost(
            @RequestBody PostCreate2Request request,
            Principal principal) {

        Long memberId = Long.valueOf(principal.getName());
        URI location = URI.create("/api/posts/" + postService.createV1(request, memberId));

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deleteByIdV2(postId);
        return ResponseEntity.noContent().build();
    }
}
