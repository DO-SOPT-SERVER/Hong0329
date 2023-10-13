package com.server.dosopt.firstseminar.FirstSeminar.controller;

import com.server.dosopt.firstseminar.FirstSeminar.common.response.ApiResponse;
import com.server.dosopt.firstseminar.FirstSeminar.common.response.SuccessStatus;
import com.server.dosopt.firstseminar.FirstSeminar.dto.HealthCheckResponse;
import com.server.dosopt.firstseminar.FirstSeminar.sample.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;

@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping("/v1")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthCheckV3() {
        Person person = new Person("최", "윤한");
        Person person2 = Person.builder()
                .lastName("최")
                .firstName("윤한")
                .build();
        return "OK"+person2.getFirstName()+person2.getLastName();
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String,String>> healthCheckV4(){
        Map<String,String> response = new HashMap<>();
        response.put("status","OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthCheckV5(){
        return ResponseEntity.ok(new HealthCheckResponse());
    }
    @GetMapping("/v6")
    public ApiResponse healthCheckV6(){
        return ApiResponse.success(SuccessStatus.HEALTHCHECK_OK.getStatusCode(),SuccessStatus.HEALTHCHECK_OK.getMessage());
    }
}