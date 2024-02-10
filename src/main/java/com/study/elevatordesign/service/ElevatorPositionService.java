package com.study.elevatordesign.service;

import com.study.elevatordesign.model.*;
import com.study.elevatordesign.repository.ElevatorPositionRepository;
import com.study.elevatordesign.repository.ElevatorStopRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ElevatorPositionService {

    private final ElevatorPositionRepository repository;

    private final ElevatorStopRepository stopRepository;

    public ElevatorPosition createElevatorPosition(ElevatorPosition elevatorPosition) {
        return repository.save(elevatorPosition);
    }

    @Transactional
    public ElevatorPosition updateElevatorPosition(ElevatorPosition elevatorPosition) {
        ElevatorFloorCompKey elevatorFloorCompKey = ElevatorFloorCompKey.builder()
                .elevatorId(elevatorPosition.getElevatorCompKey().getElevatorId())
                .elevatorSystemId(elevatorPosition.getElevatorCompKey().getElevatorSystemId())
                .floorNumber(elevatorPosition.getCurrentFloorNumber())
                .build();
        List<ElevatorStop> stops = stopRepository.
                getAllByElevatorFloorCompKey_ElevatorSystemIdAndElevatorFloorCompKey_ElevatorIdAndStopStatus(elevatorFloorCompKey.getElevatorSystemId(),elevatorFloorCompKey.getElevatorId(), StopStatus.NOT_COMPLETED);

        ElevatorStop stopReached = checkEquals(elevatorPosition, stops);
        if(stopReached != null){
            stopReached.setStopStatus(StopStatus.COMPLETED);
            stopRepository.save(stopReached);
            if(stops.isEmpty() || stops.size()==1){
                elevatorPosition.setDirection(DirectionSide.NOT_MOVING);
            }
        }

        createElevatorPosition(elevatorPosition);
        return elevatorPosition;
    }

    private ElevatorStop checkEquals(ElevatorPosition elevatorPosition, List<ElevatorStop> stops) {
        for (ElevatorStop stop : stops) {
                if (stop.getElevatorFloorCompKey().getFloorNumber() == elevatorPosition.getCurrentFloorNumber()) {
                        return stop;
                    }
        }
        return null;
    }
}
