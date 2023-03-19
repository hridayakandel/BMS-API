package com.miu.bmsapi.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Badge {
    @Id
    @GeneratedValue
    private int id;
    private Member member;
    private List<TimeSlot> validTimeSlots;
    // Constructor, getters and setters
}
