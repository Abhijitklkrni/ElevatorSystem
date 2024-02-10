package com.study.elevatordesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Elevator {

    @EmbeddedId
    private ElevatorCompKey elevatorCompKey;

    private String name;

    private int occupancySize;

}
