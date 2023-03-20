package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
