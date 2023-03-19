package com.miu.bmsapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginCredentials {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;

}
