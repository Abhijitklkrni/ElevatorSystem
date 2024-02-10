package com.study.elevatordesign.strategy;

import com.study.elevatordesign.model.Elevator;
import com.study.elevatordesign.model.UserRequest;
import org.springframework.stereotype.Service;

@Service
public abstract class ElevatorFetchingStrategy {

    public abstract String getElevator(UserRequest userRequest);
}
