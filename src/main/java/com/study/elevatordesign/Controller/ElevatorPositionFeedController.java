package com.study.elevatordesign.Controller;

import com.study.elevatordesign.model.ElevatorPosition;
import com.study.elevatordesign.service.ElevatorPositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/elevatorPositionFeed")
public class ElevatorPositionFeedController {

    final ElevatorPositionService service;

    @PutMapping
    public ElevatorPosition updateElevatorPosition(@RequestBody ElevatorPosition elevatorPosition){
        return service.updateElevatorPosition(elevatorPosition);
    }
}
