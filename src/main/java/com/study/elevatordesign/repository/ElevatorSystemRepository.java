package com.study.elevatordesign.repository;

import com.study.elevatordesign.model.ElevatorSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElevatorSystemRepository extends JpaRepository<ElevatorSystem,Integer> {
}
