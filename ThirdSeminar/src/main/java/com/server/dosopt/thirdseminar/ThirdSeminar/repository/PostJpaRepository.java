package com.server.dosopt.thirdseminar.ThirdSeminar.repository;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);
//    Post findAllByMemberId(Long memberId);
}
