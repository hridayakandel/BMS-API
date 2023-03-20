package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Member;
import org.springframework.http.ResponseEntity;

public interface MemberService extends GenericService<Member>{
    ResponseEntity assignBadge(Integer memberId, Integer badgeId);

    Member getByBatchID(Integer badgeID);
}
