package com.study.elevatordesign.service;

import com.study.elevatordesign.model.Elevator;
import com.study.elevatordesign.repository.ElevatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ElevatorService {

    private final ElevatorRepository elevatorRepository;

    public Elevator createElevator(Elevator elevator) {
        return elevatorRepository.save(elevator);
    }
}
