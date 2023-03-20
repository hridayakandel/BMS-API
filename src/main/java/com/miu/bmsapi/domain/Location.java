package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.LocationType;
import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;
}
