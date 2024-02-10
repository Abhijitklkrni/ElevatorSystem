package com.study.elevatordesign.repository;

import com.study.elevatordesign.model.Elevator;
import com.study.elevatordesign.model.ElevatorCompKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElevatorRepository extends JpaRepository<Elevator, ElevatorCompKey> {

    public Elevator getElevatorByElevatorCompKey_ElevatorIdAndElevatorCompKey_ElevatorSystemId(int elevatorId, int elevatorSystemId);
}
