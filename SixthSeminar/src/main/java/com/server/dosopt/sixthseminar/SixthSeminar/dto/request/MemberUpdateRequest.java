package com.server.dosopt.sixthseminar.SixthSeminar.dto.request;

import com.server.dosopt.sixthseminar.SixthSeminar.domain.Part;

public record MemberUpdateRequest (
    int generation,
    Part part
){
    public static MemberUpdateRequest of(int generation, Part part){
        return new MemberUpdateRequest(generation, part);
    }
}
