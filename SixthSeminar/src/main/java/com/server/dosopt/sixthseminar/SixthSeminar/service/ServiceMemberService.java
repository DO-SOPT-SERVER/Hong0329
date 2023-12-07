package com.server.dosopt.sixthseminar.SixthSeminar.service;

import com.server.dosopt.sixthseminar.SixthSeminar.config.jwt.JwtTokenProvider;
import com.server.dosopt.sixthseminar.SixthSeminar.config.jwt.UserAuthentication;
import com.server.dosopt.sixthseminar.SixthSeminar.domain.ServiceMember;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.servicemember.ServiceMemberRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.response.ServiceMemberResponse;
import com.server.dosopt.sixthseminar.SixthSeminar.repository.ServiceMemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceMemberService {

    private final ServiceMemberJpaRepository serviceMemberJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String create(ServiceMemberRequest request) {
        ServiceMember serviceMember = ServiceMember.builder()
                .nickname(request.nickname())
                .password(passwordEncoder.encode(request.password()))
                .build();
        serviceMemberJpaRepository.save(serviceMember);

        return serviceMember.getId().toString();
    }

    public ServiceMemberResponse signIn(ServiceMemberRequest request) {
        ServiceMember serviceMember = serviceMemberJpaRepository.findByNickname(request.nickname())
                .orElseThrow(() -> new RuntimeException("해당하는 회원이 없습니다."));
        if (!passwordEncoder.matches(request.password(), serviceMember.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return ServiceMemberResponse.builder()
                .nickname(serviceMember.getNickname())
                .accessToken(jwtTokenProvider.generateToken(
                        new UserAuthentication(serviceMember.getId(),null,null), 50*1000L*60*24*365))
                .build();
    }

}
