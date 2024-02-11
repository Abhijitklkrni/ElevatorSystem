package com.study.elevatordesign.strategy;

import com.study.elevatordesign.model.*;

import com.study.elevatordesign.repository.ElevatorPositionRepository;
import com.study.elevatordesign.repository.ElevatorStopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component(value = "QuickFetch")
@Transactional
@AllArgsConstructor
public class QuickElevatorFetchStrategy extends ElevatorFetchingStrategy{

    final ElevatorPositionRepository repository;

    final ElevatorStopRepository elevatorStopRepository;
    @Override
    @Transactional()
    public String getElevator(UserRequest userRequest) {
        List<ElevatorPosition> elevatorPositions;

        if(userRequest.getDirection().equalsIgnoreCase("UP")){
            elevatorPositions = repository.getAllByDirectionEqualsAndCurrentFloorNumberLessThanAndSpaceLeftGreaterThanEqual(DirectionSide.valueOf(userRequest.getDirection()),userRequest.getToFloor()-3, userRequest.getNumberOfPersons());
        }else{
            elevatorPositions = repository.getAllByDirectionEqualsAndCurrentFloorNumberGreaterThanEqualAndSpaceLeftGreaterThanEqual(DirectionSide.valueOf(userRequest.getDirection()),userRequest.getToFloor()+3, userRequest.getNumberOfPersons());
        }
        ElevatorPosition selected;
        if(!elevatorPositions.isEmpty()){
           selected = elevatorPositions.get(0);
        }else{
            selected = repository.findNearestElevator(userRequest.getFromFloor()).get(0);
        }

        int elevatorId = selected.getElevatorCompKey().getElevatorId();
        int elevatorSystemId = selected.getElevatorCompKey().getElevatorSystemId();
        String elevatorName = String.valueOf(elevatorId);
        ElevatorPosition updatedElevatorPosition = ElevatorPosition.builder()
                .elevatorCompKey(ElevatorCompKey.builder()
                        .elevatorId(elevatorId)
                        .elevatorSystemId(elevatorSystemId)
                        .build())
                .currentFloorNumber(selected.getCurrentFloorNumber())
                .direction(DirectionSide.valueOf(userRequest.getDirection()))
                .spaceLeft(selected.getSpaceLeft()- userRequest.getNumberOfPersons())
                .build();

        repository.save(updatedElevatorPosition);
        ElevatorStop stop = getElevatorStop(selected, userRequest.getToFloor());
        elevatorStopRepository.save(stop);
        ElevatorStop fromStop = getFromElevatorStop(selected,userRequest.getFromFloor());
        elevatorStopRepository.save(fromStop);
        return elevatorName;
    }

    public ElevatorStop getElevatorStop(ElevatorPosition position,int toFloor){
        return ElevatorStop.builder()
                .elevatorFloorCompKey(ElevatorFloorCompKey.builder()
                        .elevatorId(position.getElevatorCompKey().getElevatorId())
                        .elevatorSystemId(position.getElevatorCompKey().getElevatorSystemId())
                        .floorNumber(toFloor)
                        .build())
                .stopStatus(StopStatus.NOT_COMPLETED)
                .build();
    }

    public ElevatorStop getFromElevatorStop(ElevatorPosition position,int fromFloor){
        return ElevatorStop.builder()
                .elevatorFloorCompKey(ElevatorFloorCompKey.builder()
                        .elevatorId(position.getElevatorCompKey().getElevatorId())
                        .elevatorSystemId(position.getElevatorCompKey().getElevatorSystemId())
                        .floorNumber(fromFloor)
                        .build())
                .stopStatus(StopStatus.NOT_COMPLETED)
                .build();
    }


}
