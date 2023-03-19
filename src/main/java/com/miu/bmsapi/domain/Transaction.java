package com.miu.bmsapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime dateTime;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Membership membership;
    @ManyToOne
    private Location location;

}
