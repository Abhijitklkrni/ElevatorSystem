package com.study.elevatordesign.Controller;

import com.study.elevatordesign.model.ElevatorPosition;
import com.study.elevatordesign.service.ElevatorPositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/elevatorPosition")
public class ElevatorPositionController {

    ElevatorPositionService service;

    @PostMapping
    public ElevatorPosition createElevatorPosition(@RequestBody ElevatorPosition elevatorPosition){
        return service.createElevatorPosition(elevatorPosition);
    }
}
