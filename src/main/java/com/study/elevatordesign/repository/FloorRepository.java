package com.study.elevatordesign.repository;

import com.study.elevatordesign.model.ElevatorFloorCompKey;
import com.study.elevatordesign.model.Floor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, ElevatorFloorCompKey> {
}
