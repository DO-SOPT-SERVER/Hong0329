package com.server.dosopt.sixthseminar.SixthSeminar.repository;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);
//    Post findAllByMemberId(Long memberId);
}
