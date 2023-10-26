package com.server.dosopt.secondseminar.SecondSeminar.repository;

import com.server.dosopt.secondseminar.SecondSeminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
//    default Member findByIdOrThrow(Long memberId){
//
//        return null;
//    }
}
