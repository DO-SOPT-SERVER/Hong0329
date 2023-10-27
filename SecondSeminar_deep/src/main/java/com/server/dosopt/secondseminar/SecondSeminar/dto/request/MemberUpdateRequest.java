package com.server.dosopt.secondseminar.SecondSeminar.dto.request;

import com.server.dosopt.secondseminar.SecondSeminar.domain.Part;

public record MemberUpdateRequest (
    int generation,
    Part part
){
    public static MemberUpdateRequest of(int generation, Part part){
        return new MemberUpdateRequest(generation, part);
    }
}
