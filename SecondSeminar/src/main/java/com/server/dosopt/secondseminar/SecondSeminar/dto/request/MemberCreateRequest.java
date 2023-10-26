package com.server.dosopt.secondseminar.SecondSeminar.dto.request;

import com.server.dosopt.secondseminar.SecondSeminar.domain.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}
