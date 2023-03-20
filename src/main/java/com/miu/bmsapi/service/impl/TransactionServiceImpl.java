package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.*;
import com.miu.bmsapi.enums.WeekDays;
import com.miu.bmsapi.repository.TransactionRepo;
import com.miu.bmsapi.service.*;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepo transactionRepo;

    private BadgeService badgeService;

    private MemberService memberService;

    private MembershipService membershipService;

    LocationService locationService;
    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction getById(int id) {
        return transactionRepo.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }

    @Override
    public ResponseEntity<?> validateAndSave(Integer badgeId, Integer locationId) {

        Badge badge = badgeService.getById(badgeId);

        if(badge.isActive()){
            Member member = memberService.getByBatchID(badgeId);
            Location location = locationService.getById(locationId);

           boolean isOnLocation=false;

           for(int i=0; i<member.getMembershipList().size();i++){
               for(int j=0; j<member.getMembershipList().size();j++){
                   for (int k=0; k<member.getMembershipList().get(j).getPlan().getLocationList().size();k++){
                       if(member.getMembershipList().get(j).getPlan().getLocationList().get(k).getId()==locationId){
                           isOnLocation=true;
                           break;
                       }
                   }
               }
           }
           if(isOnLocation){
               boolean isOnTimeRage=false;

               location.getSchedule().getWeekDayList().forEach(weekDay -> {
                   if(weekDay.getName().name().equals(WeekDays.THURSDAY.name())){
                       weekDay.getTimeSlotList().forEach(timeSlot -> {
                         //  if(timeSlot.getStartTime().isBefore(LocalTime.now()) && timeSlot.getEndTime().isAfter(LocalTime.now())){
                             // Do transaction

//                               member.ad
                         //  }
                       });
                   }
               });

           }

        }else
            return ResponseEntity.badRequest().body("Badge is inactive");

        return null;
    }
}
