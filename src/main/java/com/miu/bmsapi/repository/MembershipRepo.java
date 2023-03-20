package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepo extends JpaRepository<Membership,Integer>{
}
