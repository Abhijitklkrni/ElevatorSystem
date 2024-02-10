package com.study.elevatordesign.model;

import com.study.elevatordesign.model.Elevator;
import com.study.elevatordesign.model.Floor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ElevatorSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private int totalFloors;

    @OneToMany
    private List<Elevator> elevators;

    @OneToMany
    private List<Floor> floors;


    public ElevatorSystem(String name, String location, int totalFloors) {
        this.name = name;
        this.location = location;
        this.totalFloors = totalFloors;
    }

    public ElevatorSystem() {

    }
}
