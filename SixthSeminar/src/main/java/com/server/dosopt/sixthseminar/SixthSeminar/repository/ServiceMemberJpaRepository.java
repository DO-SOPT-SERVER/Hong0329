package com.server.dosopt.sixthseminar.SixthSeminar.repository;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.ServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceMemberJpaRepository extends JpaRepository<ServiceMember,Long> {
    Optional<ServiceMember> findByNickname(String nickname);

}
