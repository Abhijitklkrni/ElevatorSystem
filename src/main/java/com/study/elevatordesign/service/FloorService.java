package com.study.elevatordesign.service;

import com.study.elevatordesign.model.Floor;
import com.study.elevatordesign.repository.FloorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FloorService {

    private final FloorRepository repository;

    public Floor createFloor(Floor floor) {
        return repository.save(floor);
    }

    public Floor updateFloor(Floor floor) {
        return repository.save(floor);
    }
}
