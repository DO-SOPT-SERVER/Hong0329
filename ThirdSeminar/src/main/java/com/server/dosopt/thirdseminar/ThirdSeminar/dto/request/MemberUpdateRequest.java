package com.server.dosopt.thirdseminar.ThirdSeminar.dto.request;

import com.server.dosopt.thirdseminar.ThirdSeminar.domain.Part;

public record MemberUpdateRequest (
    int generation,
    Part part
){
    public static MemberUpdateRequest of(int generation, Part part){
        return new MemberUpdateRequest(generation, part);
    }
}
