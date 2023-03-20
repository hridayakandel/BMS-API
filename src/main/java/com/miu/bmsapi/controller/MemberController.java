package com.miu.bmsapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.dto.MemberDto;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.service.BadgeService;
import com.miu.bmsapi.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Bag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@AllArgsConstructor
public class MemberController{

    private MemberService memberService;

    private BadgeService badgeService;
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Member> save(@RequestBody MemberDto member){
        Member memberEntity=objectMapper.convertValue(member,Member.class);
        return new ResponseEntity<>(memberService.save(memberEntity), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Member>> getAll(){

        return ResponseEntity.ok(memberService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable int id){
        return ResponseEntity.ok(memberService.getById(id));
    }
    @PostConstruct
    public void  insertDummydata(){
        Member member = Member.builder().email("hridaya@gmail.com").firstName("hridaya").lastName("kandel").roles(Arrays.asList(Role.ADMIN)).build();
        memberService.save(member);
    }
}
