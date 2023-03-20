package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.repository.TimeSlotRepo;
import com.miu.bmsapi.repository.WeekDayRepo;
import com.miu.bmsapi.service.LocationService;
import com.miu.bmsapi.service.MemberService;
import com.miu.bmsapi.service.MembershipService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {


    MemberService memberService;
    MembershipService membershipService;
    LocationService locationService;

    TimeSlotRepo timeSlotRepo;

    WeekDayRepo weekDayRepo;

    @GetMapping("/member/{memberId}/badge/{badgeId}")
    public ResponseEntity<?> assignBadge(@PathVariable("memberId") Integer memberId, @PathVariable("badgeId")Integer badgeId) {

       return memberService.assignBadge(memberId, badgeId);

    }

    @GetMapping("/member/{memberId}/membership/{membershipId}")
    public ResponseEntity<?> assignMembershipToMember(@PathVariable("memberId") Integer memberId, @PathVariable("membershipId")Integer badgeId) {

        return membershipService.assignMembership(memberId, badgeId);

    }


    @GetMapping("/membership/{membershipId}/plan/{planId}")
    public ResponseEntity<?> assignPlanToMembership(@PathVariable("planId") Integer planId, @PathVariable("membershipId")Integer membershipId) {

        return membershipService.assignPlanToMembership(planId, membershipId);

    }

    @PostMapping("/location/{locationId}/schedule/{scheduleId}")
    public ResponseEntity<?> assignScheduleToLocation(@PathVariable("locationId") Integer locationId, @PathVariable("scheduleId")Integer scheduleId) {

        return locationService.assignScheduleToLocation(locationId, scheduleId);

    }

    @PostMapping("/weekday/{weekId}/timeslot/{timeslotId}")
    public ResponseEntity<?> assignTimeslotToWeekDay(@PathVariable("weekId") Integer weekId, @PathVariable("timeslotId")Integer timeslotId) {

        TimeSlot timeSlot= timeSlotRepo.findById(timeslotId).orElse(null);

        WeekDay weekDay = weekDayRepo.findById(weekId).orElse(null);

        if(null!=timeSlot&& null!=weekDay){
            weekDay.addTimeSlotList(timeSlot);
            weekDayRepo.save(weekDay);
            return ResponseEntity.ok("Assigned");
        }


        return ResponseEntity.notFound().build();

    }





}
