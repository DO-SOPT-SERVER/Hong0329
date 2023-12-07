package com.server.dosopt.sixthseminar.SixthSeminar.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record PostCreate2Request(
        String title,
        String content,
        MultipartFile image
) {
}