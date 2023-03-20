package com.miu.bmsapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.domain.Plan;
import com.miu.bmsapi.enums.LocationType;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.service.PlanService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
@AllArgsConstructor
public class PlanController{

    private PlanService planService;
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Plan> save(@RequestBody Plan plan){
       // Plan planEntity=objectMapper.convertValue(plan,Plan.class);
        return new ResponseEntity<>(planService.save(plan), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Plan>> getAll(){

        return ResponseEntity.ok(planService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Plan> getById(@PathVariable int id){
        return ResponseEntity.ok(planService.getById(id));
    }

    @PostConstruct
    public void  insertDummydata(){
        Location location = Location.builder().name("Argiro").type(LocationType.DINING_HALL).capacity(100).description("Argiro").build();
        Plan plan = Plan.builder().name("Student Meal Plan").description("Meal is allowed 20 times a month for student")
                .allowedRolesList(Arrays.asList(Role.ADMIN,Role.STUDENT))
                .locationList(Arrays.asList(location)).build();
        planService.save(plan);

    }
}
