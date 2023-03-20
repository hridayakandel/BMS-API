package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepo extends JpaRepository<TimeSlot,Integer> {
}
