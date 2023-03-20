package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Plan;
import com.miu.bmsapi.repository.PlanRepo;
import com.miu.bmsapi.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PlanServiceImpl implements PlanService {
    private PlanRepo planRepo;
    @Override
    public Plan save(Plan plan) {
        return planRepo.save(plan);
    }

    @Override
    public Plan update(Plan plan) {
        return null;
    }

    @Override
    public Plan getById(int id) {
        return planRepo.findById(id).orElse(null);
    }

    @Override
    public List<Plan> getAll() {
        return planRepo.findAll();
    }
}
