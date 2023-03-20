package com.miu.bmsapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.service.TimeSlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/time-slots")
@AllArgsConstructor
public class TimeSlotController {
    private TimeSlotService timeSlotService;
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<TimeSlot> save(@RequestBody TimeSlot timeSlot){
        // TimeSlot timeSlotEntity=objectMapper.convertValue(timeSlot,TimeSlot.class);
        return new ResponseEntity<>(timeSlotService.save(timeSlot), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<TimeSlot>> getAll(){

        return ResponseEntity.ok(timeSlotService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TimeSlot> getById(@PathVariable int id){
        return ResponseEntity.ok(timeSlotService.getById(id));
    }

//    @PostConstruct
//    public void  insertDummydata(){
//        TimeSlot timeSlot1 = TimeSlot.builder().startTime(LocalTime.of(10,20)).endTime(LocalTime.of(12,20)).build();
//        TimeSlot timeSlot2 = TimeSlot.builder().startTime(LocalTime.of(10,20)).endTime(LocalTime.of(12,20)).build();
//
//        timeSlotService.save(timeSlot1);
//        timeSlotService.save(timeSlot2);
//
//    }
}
