package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Location;
import org.springframework.http.ResponseEntity;

public interface LocationService extends GenericService<Location>{
    ResponseEntity<?> assignScheduleToLocation(Integer locationId, Integer scheduleId);
}
