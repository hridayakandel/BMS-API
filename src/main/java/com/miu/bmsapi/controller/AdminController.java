package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.repository.TimeSlotRepo;
import com.miu.bmsapi.repository.WeekDayRepo;
import com.miu.bmsapi.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    AdminService adminService;

    @GetMapping("/member/{memberId}/badge/{badgeId}")
    public ResponseEntity<?> assignBadge(@PathVariable("memberId") Integer memberId, @PathVariable("badgeId")Integer badgeId) {
       return adminService.assignBadge(memberId, badgeId);
    }

    @GetMapping("/member/{memberId}/membership/{membershipId}")
    public ResponseEntity<?> assignMembershipToMember(@PathVariable("memberId") Integer memberId, @PathVariable("membershipId")Integer membershipId) {
        return adminService.assignMembership(memberId, membershipId);

    }

    @GetMapping("/membership/{membershipId}/plan/{planId}")
    public ResponseEntity<?> assignPlanToMembership(@PathVariable("planId") Integer planId, @PathVariable("membershipId")Integer membershipId) {
        return adminService.assignPlanToMembership(planId, membershipId);
    }

    @PostMapping("/location/{locationId}/schedule/{scheduleId}")
    public ResponseEntity<?> assignScheduleToLocation(@PathVariable("locationId") Integer locationId, @PathVariable("scheduleId")Integer scheduleId) {
        return adminService.assignScheduleToLocation(locationId, scheduleId);
    }

    @PostMapping("/weekday/{weekId}/timeslot/{timeslotId}")
    public ResponseEntity<?> assignTimeslotToWeekDay(@PathVariable("weekId") Integer weekId, @PathVariable("timeslotId")Integer timeslotId) {
       return adminService.assignTimeslotToWeekDay(weekId, timeslotId);
    }


}
