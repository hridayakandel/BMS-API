package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.domain.Schedule;
import com.miu.bmsapi.repository.LocationRepo;
import com.miu.bmsapi.repository.ScheduleRepo;
import com.miu.bmsapi.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private LocationRepo locationRepo;

    private ScheduleRepo scheduleRepo;

    @Override
    public Location save(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Location update(Location location) {
        return null;
    }

    @Override
    public Location getById(int id) {
        return locationRepo.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAll() {
        return locationRepo.findAll();
    }

    @Override
    public ResponseEntity<?> assignScheduleToLocation(Integer locationId, Integer scheduleId) {

        Location location = getById(locationId);
        Schedule schedule = scheduleRepo.findById(scheduleId).orElse(null);

        if (null != location && null != schedule) {
            location.setSchedule(schedule);
            save(location);
            return ResponseEntity.ok(schedule.getName()+ " schedule assign to " + location.getName());
        }

        return ResponseEntity.notFound().build();
    }
}
