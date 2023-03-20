package com.miu.bmsapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import com.miu.bmsapi.enums.MembershipType;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Membership {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private MembershipType membershipType;
    @ManyToOne
    private Plan plan;
    @OneToMany
    private List<Transaction> transactionList;

}
