package com.miu.bmsapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    @ManyToOne
    private Plan plan;
    @ManyToOne
    private Member member;
    @OneToMany
    private List<Transaction> transactionList;

}
