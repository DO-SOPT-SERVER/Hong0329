package com.server.dosopt.sixthseminar.SixthSeminar.dto.request;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.SOPT;


public record MemberCreateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
){

}
