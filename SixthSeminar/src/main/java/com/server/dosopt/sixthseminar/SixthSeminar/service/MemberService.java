package com.server.dosopt.sixthseminar.SixthSeminar.service;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Member;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.MemberCreateRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.response.MemberGetResponse;
import com.server.dosopt.sixthseminar.SixthSeminar.domain.SOPT;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.request.MemberUpdateRequest;
import com.server.dosopt.sixthseminar.SixthSeminar.dto.response.MemberUpdateResponse;
import com.server.dosopt.sixthseminar.SixthSeminar.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getByIdV1(Long memberId){
        Member member = memberJpaRepository.findById(memberId).get();
        MemberGetResponse response = MemberGetResponse.of(member);
        return response;
    }

    public MemberGetResponse getByIdV2(Long memberId) {
        Member member = memberJpaRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원이 없습니다."));
        return MemberGetResponse.of(member);
        //return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
    }

    public List<MemberGetResponse> getMembers(){
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public String create(MemberCreateRequest request){
        Member member = memberJpaRepository.save(Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public MemberUpdateResponse updateSOPT(Long memberId, MemberUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(SOPT.builder()
                .generation(request.generation())
                .part(request.part())
                .build());
        return MemberUpdateResponse.of(member.getSopt().getGeneration(), member.getSopt().getPart());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }

    private Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 회원이 없습니다.")
        );
    }
}
