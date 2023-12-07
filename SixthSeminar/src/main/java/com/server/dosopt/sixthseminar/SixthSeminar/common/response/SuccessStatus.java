package com.server.dosopt.sixthseminar.SixthSeminar.common.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum SuccessStatus {
    HEALTHCHECK_OK(HttpStatus.OK,"헬스 체크 성공"),
    MEMBER_UPDATE_OK(HttpStatus.OK,"수정 성공");

    private final HttpStatus httpStatus;
    private final String message;

    public int getStatusCode() {
        return this.httpStatus.value();
    }
}
