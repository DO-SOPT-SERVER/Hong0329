package com.server.dosopt.sixthseminar.SixthSeminar.dto.response;

import lombok.Builder;

@Builder
public record ServiceMemberResponse(
        String nickname,
        String accessToken
) {
}
