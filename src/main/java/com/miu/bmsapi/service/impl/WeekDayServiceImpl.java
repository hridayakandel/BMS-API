package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.repository.WeekDayRepo;
import com.miu.bmsapi.service.WeekDayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class WeekDayServiceImpl implements WeekDayService {
    private WeekDayRepo weekDayRepo;
    @Override
    public WeekDay save(WeekDay weekDay) {
        return weekDayRepo.save(weekDay);
    }

    @Override
    public WeekDay update(WeekDay weekDay) {
        return null;
    }

    @Override
    public WeekDay getById(int id) {
        return weekDayRepo.findById(id).orElse(null);
    }

    @Override
    public List<WeekDay> getAll() {
        return weekDayRepo.findAll();
    }
}
