package com.lastchain.legacynft.domain.will.repository;

import com.lastchain.legacynft.domain.will.entity.Will;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WillRepository extends JpaRepository<Will, Long> {
    List<Will> findByOwnerIdOrderByIdDesc(Long ownerId);
}
