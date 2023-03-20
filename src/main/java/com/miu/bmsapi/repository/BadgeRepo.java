package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepo extends JpaRepository<Badge,Integer> {
}
