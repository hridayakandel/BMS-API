package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.domain.Membership;
import com.miu.bmsapi.domain.Plan;
import com.miu.bmsapi.dto.MemberDto;
import com.miu.bmsapi.enums.MembershipType;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.service.MembershipService;
import com.miu.bmsapi.service.PlanService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/memberships")
public class MembershipController {
    private MembershipService membershipService;
    private PlanService planService;
    @PostMapping
    public ResponseEntity<Membership> save(@RequestBody Membership membership){
        //Member memberEntity=objectMapper.convertValue(member,Member.class);
        return new ResponseEntity<>(membershipService.save(membership), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Membership>> getAll(){

        return ResponseEntity.ok(membershipService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Membership> getById(@PathVariable int id){
        return ResponseEntity.ok(membershipService.getById(id));
    }

    @PostConstruct
    public void  insertDummydata(){
        Membership membership =Membership.builder().membershipType(MembershipType.LIMITED)
                .startDate(LocalDate.now()).endDate(LocalDate.of(2023,12,25)).build();
        membershipService.save(membership);

    }
}
