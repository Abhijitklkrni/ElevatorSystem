package com.study.elevatordesign.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ElevatorFloorCompKey implements Serializable {

    private int elevatorSystemId;
    private int elevatorId;
    private int floorNumber;
}
