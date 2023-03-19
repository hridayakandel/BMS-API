package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.LocationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private int capacity;
    private LocationType type;
//    private List<TimeSlot> timeSlots;
    @OneToMany
    private List<Transaction> transactionList;
}
