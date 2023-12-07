package com.server.dosopt.sixthseminar.SixthSeminar.dto.response;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Part;

public record MemberUpdateResponse(int generation, Part part){
    public static MemberUpdateResponse of(int generation, Part part) {
        return new MemberUpdateResponse(generation,part);
    }
}
