package com.server.dosopt.thirdseminar.ThirdSeminar.dto.response;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Part;

public record MemberUpdateResponse(int generation, Part part){
    public static MemberUpdateResponse of(int generation, Part part) {
        return new MemberUpdateResponse(generation,part);
    }
}
