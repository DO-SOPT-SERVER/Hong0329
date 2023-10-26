package com.server.dosopt.secondseminar.SecondSeminar.dto.response;

import com.server.dosopt.secondseminar.SecondSeminar.domain.Member;
import com.server.dosopt.secondseminar.SecondSeminar.domain.SOPT;

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
