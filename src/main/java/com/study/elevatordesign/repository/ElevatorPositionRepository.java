package com.study.elevatordesign.repository;

import com.study.elevatordesign.model.DirectionSide;
import com.study.elevatordesign.model.ElevatorCompKey;
import com.study.elevatordesign.model.ElevatorPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElevatorPositionRepository extends JpaRepository<ElevatorPosition, ElevatorCompKey> {

    public List<ElevatorPosition> getAllByDirectionEqualsAndCurrentFloorNumberLessThanAndSpaceLeftGreaterThanEqual(DirectionSide direction, int currentFloorNumber, int spaceLeft);

    public List<ElevatorPosition> getAllByDirectionEqualsAndCurrentFloorNumberGreaterThanEqualAndSpaceLeftGreaterThanEqual(DirectionSide direction, int currentFloorNumber, int spaceLeft);

    @Query("SELECT ep FROM ElevatorPosition ep WHERE ep.direction = 'NOT_MOVING' ORDER BY ABS(ep.currentFloorNumber - ?1) LIMIT 1")
    List<ElevatorPosition> findNearestElevator(int fromFloorNumber);

}
