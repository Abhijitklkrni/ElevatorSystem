package com.study.elevatordesign.Controller;

import com.study.elevatordesign.model.ElevatorStop;
import com.study.elevatordesign.service.ElevatorStopService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/ElevatorStop")
public class ElevatorStopController {

    private final ElevatorStopService service;

    @PostMapping
    public ElevatorStop createElevatorStop(@RequestBody ElevatorStop elevatorStop){
        return service.createElevatorStop(elevatorStop);
    }
}
