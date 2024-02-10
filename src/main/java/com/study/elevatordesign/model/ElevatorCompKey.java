package com.study.elevatordesign.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElevatorCompKey implements Serializable {

    private int elevatorSystemId;

    private int elevatorId;
}
