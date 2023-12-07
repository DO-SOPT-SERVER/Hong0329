package com.server.dosopt.sixthseminar.SixthSeminar.dto.response;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Member;
import com.server.dosopt.sixthseminar.SixthSeminar.domain.SOPT;

public record MemberGetResponse (
    String name,
    String nickname,
    int age,
    SOPT soptInfo
){
    public static MemberGetResponse of(Member member){
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
