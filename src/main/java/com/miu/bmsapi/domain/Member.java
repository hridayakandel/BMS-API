package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private List<Role> roles;

    @OneToOne
    private LoginCredentials loginCredentials;

    @OneToMany
    private List<Membership> membershipList = new ArrayList<>();
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Badge> badgeList = new ArrayList<>();

    @OneToMany
    private List<Transaction> transactionList = new ArrayList<>();


    public void addBadge(Badge badge){
        badgeList.add(badge);
    }
    public void addMembership(Membership membership){
        membershipList.add(membership);
    }


}
