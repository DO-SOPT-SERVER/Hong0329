package com.server.dosopt.thirdseminar.ThirdSeminar.repository;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long memberId){
        return findById(memberId).orElseThrow(
                ()-> new EntityNotFoundException("회원 번호를 다시 확인해주세요."));
    }
}
