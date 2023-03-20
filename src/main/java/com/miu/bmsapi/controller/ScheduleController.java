package com.miu.bmsapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.domain.Schedule;
import com.miu.bmsapi.enums.LocationType;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.service.ScheduleService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/api/v1/schedules")
@AllArgsConstructor
public class ScheduleController {
    private ScheduleService scheduleService;
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Schedule> save(@RequestBody Schedule schedule){
        // Schedule scheduleEntity=objectMapper.convertValue(schedule,Schedule.class);
        return new ResponseEntity<>(scheduleService.save(schedule), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Schedule>> getAll(){

        return ResponseEntity.ok(scheduleService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable int id){
        return ResponseEntity.ok(scheduleService.getById(id));
    }

//    @PostConstruct
//    public void  insertDummydata(){
//        Location location = Location.builder().name("Argiro").type(LocationType.DINING_HALL).capacity(100).description("Argiro").build();
//        Schedule schedule = Schedule.builder().name("Student Meal Schedule").description("Meal is allowed 20 times a month for student")
//                .allowedRolesList(Arrays.asList(Role.ADMIN,Role.STUDENT))
//                .locationList(Arrays.asList(location)).build();
//        scheduleService.save(schedule);
//
//    }
}
