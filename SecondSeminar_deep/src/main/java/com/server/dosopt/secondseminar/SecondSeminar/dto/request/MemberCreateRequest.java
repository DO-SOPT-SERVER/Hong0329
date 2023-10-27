package com.server.dosopt.secondseminar.SecondSeminar.dto.request;

import com.server.dosopt.secondseminar.SecondSeminar.domain.SOPT;


public record MemberCreateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
){

}
