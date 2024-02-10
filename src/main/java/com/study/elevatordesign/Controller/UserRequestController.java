package com.study.elevatordesign.Controller;

import com.study.elevatordesign.model.Elevator;
import com.study.elevatordesign.model.UserRequest;
import com.study.elevatordesign.service.UserRequestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/request")
public class UserRequestController {

    final UserRequestService service;

    @GetMapping
    public String getElevator(@RequestParam int elevatorSystemId,@RequestParam int fromFloor, @RequestParam int toFloor,@RequestParam int numberOfPersons){
        String direction = toFloor - fromFloor > 0 ? "UP" : "DOWN";
        UserRequest userRequest = UserRequest.builder()
                .elevatorSystemId(elevatorSystemId)
                .fromFloor(fromFloor)
                .toFloor(toFloor)
                .numberOfPersons(numberOfPersons)
                .direction(direction)
                .build();
        return service.fetchElevator(userRequest);

    }
}
