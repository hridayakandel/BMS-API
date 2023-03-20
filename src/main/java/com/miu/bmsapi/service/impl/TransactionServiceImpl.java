package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.domain.Transaction;
import com.miu.bmsapi.repository.TransactionRepo;
import com.miu.bmsapi.service.BadgeService;
import com.miu.bmsapi.service.LocationService;
import com.miu.bmsapi.service.MemberService;
import com.miu.bmsapi.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepo transactionRepo;

    private BadgeService badgeService;

    private MemberService memberService;

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

//            if(member.getMembershipList().)

        }else
            return ResponseEntity.badRequest().body("Badge is inactive");

        return null;
    }
}
