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
public class Plan {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private List<Role> allowedRolesList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Location> locationList;

}
