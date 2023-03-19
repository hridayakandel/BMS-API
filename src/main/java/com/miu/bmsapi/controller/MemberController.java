package com.miu.bmsapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.dto.MemberDto;
import com.miu.bmsapi.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@AllArgsConstructor
public class MemberController{

    private MemberService memberService;
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
}
