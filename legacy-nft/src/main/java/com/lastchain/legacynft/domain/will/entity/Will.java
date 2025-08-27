package com.lastchain.legacynft.domain.will.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "wills")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Will {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=120)
    private String title;

    @Lob @Column(nullable=false)
    private String content;

    @Column(nullable=false)
    private Long ownerId;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
