package com.miu.bmsapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.domain.Transaction;
import com.miu.bmsapi.service.BadgeService;
import com.miu.bmsapi.service.MembershipService;
import com.miu.bmsapi.service.TransactionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/badge-readers")
@AllArgsConstructor
public class BadgeReadController {

    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    private MembershipService membershipService;

    private BadgeService badgeService;

    @PostMapping("/badge/{badgeId}/location/{locationId}")
    public ResponseEntity<?> save(@PathVariable("badgeId")Integer badgeId, @PathVariable("locationId") Integer locationId){

        return transactionService.validateAndSave(badgeId,locationId);

    }
    @GetMapping
    public ResponseEntity<List<Transaction>> getAll(){

        return ResponseEntity.ok(transactionService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable int id){
        return ResponseEntity.ok(transactionService.getById(id));
    }


}
