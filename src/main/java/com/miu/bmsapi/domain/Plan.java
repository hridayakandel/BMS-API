package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.Role;
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
public class Plan {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private List<Role> allowedRoles;
    @OneToMany
    private List<Membership> membershipList;
    @OneToMany
    private List<Location> locationList;

}
