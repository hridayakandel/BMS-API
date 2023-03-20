package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.repository.MemberRepo;
import com.miu.bmsapi.service.BadgeService;
import com.miu.bmsapi.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberRepo memberRepo;
    private BadgeService badgeService;

    @Override
    public Member save(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public Member update(Member member) {
        return null;
    }

    @Override
    public Member getById(int id) {
        return memberRepo.getById(id);
    }

    @Override
    public List<Member> getAll() {
        return memberRepo.findAll();
    }

    @Override
    public ResponseEntity<?> assignBadge(Integer memberId, Integer badgeId) {
        Member member = getById(memberId);

        Badge badge = badgeService.getById(badgeId);

        if (member != null && badge != null) {
            member.getBadgeList().forEach(badge1 -> {
                badge1.setActive(false);
                badgeService.save(badge1);
            });
            member.addBadge(badge);
            save(member);
            return ResponseEntity.ok("Badge added success");
        }

        return ResponseEntity.notFound().build();

    }

    @Override
    public Member getByBatchID(Integer badgeID) {

        for (Member member : getAll()) {
            for (Badge badge : member.getBadgeList()) {
                if (badge.getId() == badgeID) {
                    return member;
                }
            }
        }

        return null;
    }

}
