package com.miu.bmsapi.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.service.WeekDayService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/week-days")
@AllArgsConstructor
public class WeekDayController {
    private WeekDayService weekDayService;
   // private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<WeekDay> save(@RequestBody WeekDay weekDay){
        // WeekDay weekDayEntity=objectMapper.convertValue(weekDay,WeekDay.class);
        return new ResponseEntity<>(weekDayService.save(weekDay), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<WeekDay>> getAll(){

        return ResponseEntity.ok(weekDayService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<WeekDay> getById(@PathVariable int id){
        return ResponseEntity.ok(weekDayService.getById(id));
    }

//    @PostConstruct
//    public void  insertDummydata(){
//        Location location = Location.builder().name("Argiro").type(LocationType.DINING_HALL).capacity(100).description("Argiro").build();
//        WeekDay weekDay = WeekDay.builder().name("Student Meal WeekDay").description("Meal is allowed 20 times a month for student")
//                .allowedRolesList(Arrays.asList(Role.ADMIN,Role.STUDENT))
//                .locationList(Arrays.asList(location)).build();
//        weekDayService.save(weekDay);
//
//    }
}
