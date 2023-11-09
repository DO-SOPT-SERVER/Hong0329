package com.server.dosopt.thirdseminar.ThirdSeminar.dto.response;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Member;
import com.server.dosopt.thirdseminar.ThirdSeminar.domain.SOPT;

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
