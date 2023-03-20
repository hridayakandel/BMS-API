package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Badge;

public interface BadgeService extends GenericService<Badge>{

    boolean getActiveID(int id);

}
