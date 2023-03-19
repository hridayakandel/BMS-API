package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.Role;
import jakarta.persistence.*;
import lombok.*;

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
    private List<Membership> membershipList;
    @OneToMany
    private List<Badge> badgeList;

    @OneToMany
    private List<Transaction> transactionList;

}
