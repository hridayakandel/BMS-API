package com.miu.bmsapi.dto;

import com.miu.bmsapi.enums.Role;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private List<Role> roles;


}
