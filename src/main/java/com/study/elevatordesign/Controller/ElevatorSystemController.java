package com.study.elevatordesign.Controller;

import com.study.elevatordesign.model.ElevatorSystem;
import com.study.elevatordesign.service.ElevatorSystemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/elevatorSystem")
@AllArgsConstructor
public class ElevatorSystemController {

    private final ElevatorSystemService service;

    @PostMapping
    public ElevatorSystem createElevatorSystem(@RequestParam String name, @RequestParam String location, @RequestParam int totalFloors){
        ElevatorSystem system = new ElevatorSystem(name,location,totalFloors);
        return service.createNewSystem(system);
    }

    @GetMapping
    public String getSystem(){
        return "System:"+1;
    }
}
