package com.server.dosopt.secondseminar.SecondSeminar.controller;

import com.server.dosopt.secondseminar.SecondSeminar.common.response.ApiResponse;
import com.server.dosopt.secondseminar.SecondSeminar.common.response.SuccessStatus;
import com.server.dosopt.secondseminar.SecondSeminar.dto.request.MemberCreateRequest;
import com.server.dosopt.secondseminar.SecondSeminar.dto.request.MemberUpdateRequest;
import com.server.dosopt.secondseminar.SecondSeminar.dto.response.MemberGetResponse;
import com.server.dosopt.secondseminar.SecondSeminar.dto.response.MemberUpdateResponse;
import com.server.dosopt.secondseminar.SecondSeminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.server.dosopt.secondseminar.SecondSeminar.common.response.SuccessStatus.MEMBER_UPDATE_OK;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV1(memberId));
    }

    @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV2(memberId));
    }

    // 생성
    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        URI location =  URI.create("api/member/" + memberService.create(request));
        return ResponseEntity.created(location).build();
    }

    // 목록 조회
    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    //수정
    @PatchMapping("/{memberId}")
    public ApiResponse<MemberUpdateResponse> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberUpdateRequest request) {
        //memberService.updateSOPT(memberId, request);
        //return ResponseEntity.noContent().build();
        return ApiResponse.success(MEMBER_UPDATE_OK,memberService.updateSOPT(memberId,request));
    }


    // 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
