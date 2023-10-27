package com.server.dosopt.secondseminar.SecondSeminar.dto.response;

import com.server.dosopt.secondseminar.SecondSeminar.domain.Part;
import com.server.dosopt.secondseminar.SecondSeminar.domain.SOPT;

public record MemberUpdateResponse(int generation, Part part){
    public static MemberUpdateResponse of(int generation, Part part) {
        return new MemberUpdateResponse(generation,part);
    }
}
