package com.server.dosopt.sixthseminar.SixthSeminar.dto.response;

import lombok.Getter;

@Getter
public class HealthCheckResponse {
    private static final String STATUS = "OK";
    private String status;
    public HealthCheckResponse() {
        this.status = STATUS;
    }
}

