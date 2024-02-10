package com.study.elevatordesign.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElevatorFloorKey implements Serializable {

    private int elevatorSystemId;
    private int floorNumber;

}
