package com.server.dosopt.sixthseminar.SixthSeminar.service;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Category;
import com.server.dosopt.sixthseminar.SixthSeminar.domain.Member;
import com.server.dosopt.sixthseminar.SixthSeminar.domain.Post;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.PostCreateRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.PostUpdateRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.response.PostGetResponse;
import com.server.dosopt.sixthseminar.SixthSeminar.repository.MemberJpaRepository;
import com.server.dosopt.sixthseminar.SixthSeminar.repository.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class PostService {
//
//    private final PostJpaRepository postJpaRepository;
//    private final MemberJpaRepository memberJpaRepository;
//    private final CategoryService categoryService;
//
//    public List<PostGetResponse> getPosts(Long memberId) {
//        return postJpaRepository.findAllByMemberId(memberId)
//                .stream()
//                .map(post -> PostGetResponse.of(post))
//                .toList();
//    }
//
//    public PostGetResponse getById(Long postId) {
//        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
//        return PostGetResponse.of(post);
//    }
//
//    private Category getCategoryByPost(Post post) {
//        return categoryService.getByCategoryId(post.getCategoryId());
//    }
//
//    @Transactional
//    public void editContent(Long postId, PostUpdateRequest request) {
//        Post post = postJpaRepository.findById(postId)
//                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
//        post.updateContent(request.content());
//    }
//
//    @Transactional
//    public String create(PostCreateRequest request, Long memberId) {
//        Member member = memberJpaRepository.findByIdOrThrow(memberId);
//        Post post = postJpaRepository.save(
//                Post.builder()
//                        .member(member)
//                        .title(request.title())
//                        .content(request.content())
//                        .build());
//        return post.getId().toString();
//    }
//}
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final CategoryService categoryService;

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content()).build());
        return post.getId().toString();
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        post.updateContent(request.content());
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post, getCategoryByPost(post)))
                .toList();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post, getCategoryByPost(post));
    }

    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        postJpaRepository.delete(post);
    }

    private Category getCategoryByPost(Post post) {
        return categoryService.getByCategoryId(post.getCategoryId());
    }
}