package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.domain.Membership;
import org.springframework.http.ResponseEntity;

public interface MembershipService extends GenericService<Membership>{
    ResponseEntity<?> assignMembership(Integer memberId, Integer membershipId);

    ResponseEntity<?> assignPlanToMembership(Integer planId, Integer membershipId);
}
