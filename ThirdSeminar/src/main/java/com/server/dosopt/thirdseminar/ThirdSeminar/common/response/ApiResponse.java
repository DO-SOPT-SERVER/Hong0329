package com.server.dosopt.thirdseminar.ThirdSeminar.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final int code;
    private final String status;
    private final boolean success;
    private T data;

    public static ApiResponse success(SuccessStatus status, Object data) {
        return ApiResponse.builder()
                .code(status.getStatusCode())
                .status(status.getMessage())
                .success(true)
                .data(data)
                .build();
    }

    public static ApiResponse success(int status, String message) {
        return ApiResponse.builder()
                .code(status)
                .status(message)
                .success(true)
                .build();
    }

    public static ApiResponse fail(int status, String message) {
        return ApiResponse.builder()
                .code(status)
                .status(message)
                .success(false)
                .build();
    }
}
