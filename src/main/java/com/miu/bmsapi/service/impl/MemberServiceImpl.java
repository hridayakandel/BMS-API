package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.repository.MemberRepo;
import com.miu.bmsapi.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberRepo memberRepo;
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
        return null;
    }

    @Override
    public List<Member> getAll() {
        return memberRepo.findAll();
    }
}
