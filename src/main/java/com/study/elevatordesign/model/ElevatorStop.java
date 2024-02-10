package com.study.elevatordesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElevatorStop {

    @EmbeddedId
    ElevatorFloorCompKey elevatorFloorCompKey;

    @Enumerated(EnumType.STRING)
    private StopStatus stopStatus;
}
