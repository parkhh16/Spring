package com.lastchain.legacynft.domain.will.dto.res;

import com.lastchain.legacynft.domain.will.entity.Will;

public record WillRes(
        Long id,
        String title,
        String content
) {
    public static WillRes from(Will w) {
        return new WillRes(w.getId(), w.getTitle(), w.getContent());
    }
}
