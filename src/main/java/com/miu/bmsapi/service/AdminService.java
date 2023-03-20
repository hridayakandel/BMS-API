package com.miu.bmsapi.service;

import org.springframework.http.ResponseEntity;


public interface AdminService {
    ResponseEntity<?> assignBadge(Integer memberId, Integer badgeId);
    ResponseEntity<?> assignMembership(Integer memberId, Integer membershipId);
    ResponseEntity<?> assignPlanToMembership(Integer planId, Integer membershipId);
    ResponseEntity<?> assignScheduleToLocation(Integer locationId, Integer scheduleId);
    ResponseEntity<?> assignTimeslotToWeekDay(Integer weekId, Integer timeslotId);
}
