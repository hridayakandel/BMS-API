package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Schedule;
import com.miu.bmsapi.repository.ScheduleRepo;
import com.miu.bmsapi.service.ScheduleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleRepo scheduleRepo;
    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return null;
    }

    @Override
    public Schedule getById(int id) {
        return scheduleRepo.findById(id).orElse(null);
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepo.findAll();
    }
}
