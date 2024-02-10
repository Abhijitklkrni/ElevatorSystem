package com.study.elevatordesign.service;

import com.study.elevatordesign.model.ElevatorStop;
import com.study.elevatordesign.repository.ElevatorStopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ElevatorStopService {
    private ElevatorStopRepository repository;

    public ElevatorStop createElevatorStop(ElevatorStop elevatorStop) {
        return repository.save(elevatorStop);
    }
}
