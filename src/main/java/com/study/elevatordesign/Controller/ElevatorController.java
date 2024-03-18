package com.study.elevatordesign.Controller;

import com.study.elevatordesign.model.Elevator;
import com.study.elevatordesign.service.ElevatorService;
import com.study.elevatordesign.service.ElevatorSystemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/elevator")
public class ElevatorController {

    private final ElevatorService service;

    @PostMapping
    public Elevator createElevator(@RequestBody Elevator elevator){
        return service.createElevator(elevator);

    }

    public void create(){
        System.out.println("HI UMESH");
        System.out.println("2nd Hi Umesh, Hi Abhijit");
    }
}
