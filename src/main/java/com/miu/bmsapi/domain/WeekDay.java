package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.WeekDays;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeekDay {
    @Id
    @GeneratedValue
    private int Id;
    private WeekDays name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "weekId")
    private List<TimeSlot> timeSlotList = new ArrayList<>();

    public void addTimeSlotList(TimeSlot timeSlot){
        if(timeSlotList==null){
            timeSlotList= new ArrayList<>();
        }
        timeSlotList.add(timeSlot);
    }

}
