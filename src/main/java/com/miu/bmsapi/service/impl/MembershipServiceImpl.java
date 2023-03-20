package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.domain.Membership;
import com.miu.bmsapi.domain.Plan;
import com.miu.bmsapi.repository.MembershipRepo;
import com.miu.bmsapi.service.MemberService;
import com.miu.bmsapi.service.MembershipService;
import com.miu.bmsapi.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MembershipServiceImpl implements MembershipService {
    private MembershipRepo membershipRepo;
    private MemberService memberService;

    private PlanService planService;

    @Override
    public Membership save(Membership membership) {
        return membershipRepo.save(membership);
    }

    @Override
    public Membership update(Membership membership) {
        return null;
    }

    @Override
    public Membership getById(int id) {
        return membershipRepo.findById(id).orElse(null);
    }

    @Override
    public List<Membership> getAll() {
        return membershipRepo.findAll();
    }

    @Override
    public ResponseEntity<?> assignMembership(Integer memberId, Integer membershipId) {
        Member member = memberService.getById(memberId);
        Membership membership = getById(membershipId);

        if(null!=member&& null!=membership){
           member.addMembership(membership);
           memberService.save(member);
           return ResponseEntity.ok("Membership assigned to member");
        }
        return ResponseEntity.badRequest().body("Member or Membership not found");
    }

    @Override
    public ResponseEntity<?> assignPlanToMembership(Integer planId, Integer membershipId) {

        Plan plan = planService.getById(planId);
        Membership membership= getById(membershipId);

        if(null!=plan && null!=membership){
            membership.setPlan(plan);
            save(membership);
           return ResponseEntity.ok("Plan assigned to membership");
        }

        return ResponseEntity.notFound().build();
    }


}
