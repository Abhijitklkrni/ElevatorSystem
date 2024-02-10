package com.study.elevatordesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElevatorPosition {

    @EmbeddedId
    private ElevatorCompKey elevatorCompKey;

    private int currentFloorNumber;

    @Enumerated(EnumType.STRING)
    private DirectionSide direction;

    private int spaceLeft;


}
