package com.server.dosopt.thirdseminar.ThirdSeminar.dto.request;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.SOPT;


public record MemberCreateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
){

}
