package com.lastchain.legacynft.domain.will.dto.req;

import jakarta.validation.constraints.NotBlank;

public record WillReq(
        @NotBlank String title,
        @NotBlank String content
) {}
