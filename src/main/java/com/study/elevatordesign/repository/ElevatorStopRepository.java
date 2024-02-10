package com.study.elevatordesign.repository;

import com.study.elevatordesign.model.ElevatorFloorCompKey;
import com.study.elevatordesign.model.ElevatorStop;
import com.study.elevatordesign.model.StopStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElevatorStopRepository extends JpaRepository<ElevatorStop, ElevatorFloorCompKey> {

    public List<ElevatorStop> getAllByElevatorFloorCompKey_ElevatorSystemIdAndElevatorFloorCompKey_ElevatorIdAndStopStatus(int elevatorFloorCompKey_elevatorSystemId, int elevatorFloorCompKey_elevatorId, StopStatus stopStatus);
}
