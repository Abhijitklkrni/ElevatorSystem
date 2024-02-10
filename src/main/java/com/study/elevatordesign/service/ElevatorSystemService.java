package com.study.elevatordesign.service;

import com.study.elevatordesign.model.ElevatorSystem;
import com.study.elevatordesign.repository.ElevatorSystemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ElevatorSystemService {

    private final ElevatorSystemRepository repository;
    public ElevatorSystem createNewSystem(ElevatorSystem system) {
        return repository.save(system);
    }
}
