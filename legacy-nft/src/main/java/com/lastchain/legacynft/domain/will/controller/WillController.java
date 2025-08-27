package com.lastchain.legacynft.domain.will.controller;

import com.lastchain.legacynft.domain.will.dto.req.WillReq;
import com.lastchain.legacynft.domain.will.dto.res.WillRes;
import com.lastchain.legacynft.domain.will.service.WillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wills")
@RequiredArgsConstructor
public class WillController {

    private final WillService service;

    @GetMapping
    public ResponseEntity<List<WillRes>> list() {
        return ResponseEntity.ok(service.myList());
    }

    @PostMapping
    public ResponseEntity<WillRes> create(@RequestBody @Valid WillReq req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WillRes> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WillRes> update(@PathVariable Long id,
                                          @RequestBody @Valid WillReq req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
