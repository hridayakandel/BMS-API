package com.miu.bmsapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.*;
import com.miu.bmsapi.enums.LocationType;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.enums.WeekDays;
import com.miu.bmsapi.repository.ScheduleRepo;
import com.miu.bmsapi.repository.TimeSlotRepo;
import com.miu.bmsapi.repository.WeekDayRepo;
import com.miu.bmsapi.service.LocationService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
@AllArgsConstructor
public class LocationController {

    private LocationService locationService;
    private ObjectMapper objectMapper;

    private TimeSlotRepo timeSlotRepo;

    private ScheduleRepo scheduleRepo;

    private WeekDayRepo weekDayRepo;

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        //Location locationEntity=objectMapper.convertValue(location,Location.class);
        return new ResponseEntity<>(locationService.save(location), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Location>> getAll() {

        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/time-slts")
    public ResponseEntity<?> getData() {
        return ResponseEntity.ok(weekDayRepo.findAll());
    }

    @GetMapping("/time-slts1")
    public ResponseEntity<?> getData1() {
        return ResponseEntity.ok(timeSlotRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable int id) {
        return ResponseEntity.ok(locationService.getById(id));
    }

    @GetMapping("/schedule")
    public void insertDummydata() {

       // TimeSlot morningTimeSlot = TimeSlot.builder().startTime(LocalTime.of(8, 30)).endTime(LocalTime.of(10, 30)).build();
     //   TimeSlot afternoonTimeSlot = TimeSlot.builder().startTime(LocalTime.of(11, 45)).endTime(LocalTime.of(13, 30)).build();

        TimeSlot morningTimeSlot = new TimeSlot(0,LocalTime.now(),LocalTime.now());
        TimeSlot afternoonTimeSlot = new TimeSlot(0,LocalTime.now(),LocalTime.now());
        TimeSlot brunchTimeSlot = TimeSlot.builder().startTime(LocalTime.of(11, 0)).endTime(LocalTime.of(13, 30)).build();
        TimeSlot eveningTimeSlot = TimeSlot.builder().startTime(LocalTime.of(5, 45)).endTime(LocalTime.of(19, 30)).build();

       timeSlotRepo.saveAll(Arrays.asList(morningTimeSlot, afternoonTimeSlot, brunchTimeSlot, eveningTimeSlot));

//        timeSlotRepo.save(morningTimeSlot);


//        var obj1 = timeSlotRepo.save(morningTimeSlot);
//         var obj2 = timeSlotRepo.save(afternoonTimeSlot);
        //var obj3 = timeSlotRepo.save(brunchTimeSlot);
        //var obj4 = timeSlotRepo.save(eveningTimeSlot);

        //WeekDay sunday = WeekDay.builder().name(WeekDays.SUNDAY).timeSlotList(Arrays.asList(morningTimeSlot)).build();
//        WeekDay monday = WeekDay.builder().name(WeekDays.MONDAY).timeSlotList(Arrays.asList(morningTimeSlot, afternoonTimeSlot, eveningTimeSlot)).build();
//        WeekDay tuesday = WeekDay.builder().name(WeekDays.TUESDAY).timeSlotList(Arrays.asList(morningTimeSlot, afternoonTimeSlot, eveningTimeSlot)).build();
        WeekDay wednesday = new WeekDay(0,WeekDays.WEDNESDAY,null);

        weekDayRepo.save(wednesday);

        WeekDay thursday = new WeekDay(0,WeekDays.THURSDAY,null);

//        thursday.addTimeSlotList(morningTimeSlot);
       // thursday.addTimeSlotList(afternoonTimeSlot);

       //WeekDay thursday = WeekDay.builder().name(WeekDays.THURSDAY).timeSlotList(List.of(morningTimeSlot,afternoonTimeSlot)).build();
//        WeekDay friday = WeekDay.builder().name(WeekDays.FRIDAY).timeSlotList(Arrays.asList(morningTimeSlot, afternoonTimeSlot, eveningTimeSlot)).build();
//        WeekDay saturday = WeekDay.builder().name(WeekDays.SATURDAY).timeSlotList(Arrays.asList(morningTimeSlot, afternoonTimeSlot, eveningTimeSlot)).build();

      //  weekDayRepo.saveAll(Arrays.asList(saturday,sunday,monday,tuesday,wednesday,thursday,friday));

        weekDayRepo.save(thursday);
        weekDayRepo.save(wednesday);


//        weekDayRepo.save(sunday);
//        weekDayRepo.save(monday);
//        weekDayRepo.save(tuesday);
//        weekDayRepo.save(wednesday);
//        weekDayRepo.save(thursday);
//        weekDayRepo.save(friday);
//        weekDayRepo.save(saturday);

        Schedule dinningHallSchedule = Schedule.builder().weekDayList(List.of(thursday,wednesday)).name("Dinning Hall").build();

        scheduleRepo.save(dinningHallSchedule);

        Location location = Location.builder().name("Argiro").type(LocationType.DINING_HALL).capacity(100).description("Argiro").schedule(dinningHallSchedule).build();
        locationService.save(location);

    }
}
