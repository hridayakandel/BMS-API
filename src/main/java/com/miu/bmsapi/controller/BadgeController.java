package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.service.BadgeService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/badges")
@AllArgsConstructor
public class BadgeController {
    private BadgeService badgeService;

    @PostMapping
    public ResponseEntity<Badge> save(@RequestBody Badge badge){
        return ResponseEntity.ok(badgeService.save(badge));
    }
    @GetMapping
    public ResponseEntity<List<Badge>> getAll(){
        return ResponseEntity.ok(badgeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Badge> getById(@PathVariable int id){
        return ResponseEntity.ok(badgeService.getById(id));
    }

    @PostConstruct
    public void  insertDummydata(){
        Badge badge= Badge.builder().active(true).build();
        badgeService.save(badge);
    }
}


