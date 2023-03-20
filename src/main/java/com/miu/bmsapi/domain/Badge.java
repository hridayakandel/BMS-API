package com.miu.bmsapi.domain;


import jakarta.persistence.*;
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
    private boolean active;
}
