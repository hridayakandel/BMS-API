package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.repository.TimeSlotRepo;
import com.miu.bmsapi.service.TimeSlotService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {

    private TimeSlotRepo timeSlotRepo;
    @Override
    public TimeSlot save(TimeSlot timeSlot) {
        return timeSlotRepo.save(timeSlot);
    }

    @Override
    public TimeSlot update(TimeSlot timeSlot) {
        return null;
    }

    @Override
    public TimeSlot getById(int id) {
        return timeSlotRepo.findById(id).orElse(null);
    }

    @Override
    public List<TimeSlot> getAll() {
        return timeSlotRepo.findAll();
    }
}
