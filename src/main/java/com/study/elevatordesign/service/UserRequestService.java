package com.study.elevatordesign.service;

import com.study.elevatordesign.model.Elevator;
import com.study.elevatordesign.model.UserRequest;
import com.study.elevatordesign.strategy.ElevatorFetchingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRequestService {

    @Qualifier(value = "QuickFetch")
    private ElevatorFetchingStrategy Strategy;

    public String fetchElevator(UserRequest userRequest) {
        return Strategy.getElevator(userRequest);
    }
}
