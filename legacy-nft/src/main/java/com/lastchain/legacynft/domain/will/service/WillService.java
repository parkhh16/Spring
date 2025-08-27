package com.lastchain.legacynft.domain.will.service;

import com.lastchain.legacynft.domain.will.dto.req.WillReq;
import com.lastchain.legacynft.domain.will.dto.res.WillRes;
import com.lastchain.legacynft.domain.will.entity.Will;
import com.lastchain.legacynft.domain.will.repository.WillRepository;
import com.lastchain.legacynft.global.error.ApiException;
import com.lastchain.legacynft.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WillService {

    private final WillRepository repo;

    private Long currentUserId() { return 1L; } // JWT 붙이기 전까지 고정

    public List<WillRes> myList() {
        return repo.findByOwnerIdOrderByIdDesc(currentUserId())
                .stream().map(WillRes::from).toList();
    }

    public WillRes create(WillReq req) {
        var saved = repo.save(Will.builder()
                .title(req.title())
                .content(req.content())
                .ownerId(currentUserId())
                .build());
        return WillRes.from(saved);
    }

    public WillRes get(Long id) {
        var w = repo.findById(id).orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND));
        if (!w.getOwnerId().equals(currentUserId())) throw new ApiException(ErrorCode.FORBIDDEN);
        return WillRes.from(w);
    }

    public WillRes update(Long id, WillReq req) {
        var w = repo.findById(id).orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND));
        if (!w.getOwnerId().equals(currentUserId())) throw new ApiException(ErrorCode.FORBIDDEN);
        w.update(req.title(), req.content());
        return WillRes.from(repo.save(w));
    }

    public void delete(Long id) {
        var w = repo.findById(id).orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND));
        if (!w.getOwnerId().equals(currentUserId())) throw new ApiException(ErrorCode.FORBIDDEN);
        repo.delete(w);
    }
}
