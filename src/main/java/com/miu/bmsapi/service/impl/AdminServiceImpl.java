package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    MemberService memberService;
    MembershipService membershipService;
    LocationService locationService;

    TimeSlotService timeSlotService;

    WeekDayService weekDayService;


    @Override
    public ResponseEntity<?> assignBadge(Integer memberId, Integer badgeId) {
        return memberService.assignBadge(memberId, badgeId);
    }

    @Override
    public ResponseEntity<?> assignMembership(Integer memberId, Integer membershipId) {
        return membershipService.assignMembership(memberId, membershipId);
    }

    @Override
    public ResponseEntity<?> assignPlanToMembership(Integer planId, Integer membershipId) {
        return membershipService.assignPlanToMembership(planId, membershipId);
    }

    @Override
    public ResponseEntity<?> assignScheduleToLocation(Integer locationId, Integer scheduleId) {
        return locationService.assignScheduleToLocation(locationId, scheduleId);
    }

    @Override
    public ResponseEntity<?> assignTimeslotToWeekDay(Integer weekId, Integer timeslotId) {

        TimeSlot timeSlot= timeSlotService.getById(timeslotId);

        WeekDay weekDay = weekDayService.getById(weekId);

        if(null!=timeSlot&& null!=weekDay){
            weekDay.addTimeSlotList(timeSlot);
            weekDayService.save(weekDay);
            return ResponseEntity.ok("Assigned");
        }


        return ResponseEntity.notFound().build();
    }


}
