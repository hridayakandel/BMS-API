package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
}
