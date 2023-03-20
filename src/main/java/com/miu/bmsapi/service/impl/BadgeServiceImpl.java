package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.repository.BadgeRepo;
import com.miu.bmsapi.service.BadgeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BadgeServiceImpl implements BadgeService {
    private BadgeRepo badgeRepo;

    @Override
    public Badge save(Badge badge) {

        return badgeRepo.save(badge);
    }

    @Override
    public Badge update(Badge badge) {
        return null;
    }

    @Override
    public Badge getById(int id) {
        return badgeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Badge> getAll() {
        return badgeRepo.findAll();
    }

    @Override
    public boolean getActiveID(int id) {
       Badge badge = getById(id);
       return badge.isActive();
    }
}
