package com.study.elevatordesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Floor {

    @EmbeddedId
    private ElevatorFloorKey elevatorFloorKey;

    private String name;

}
