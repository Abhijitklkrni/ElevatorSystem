package com.study.elevatordesign.Controller;

import com.study.elevatordesign.model.ElevatorFloorKey;
import com.study.elevatordesign.model.Floor;
import com.study.elevatordesign.service.FloorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/floor")
public class FloorController {

    private FloorService service;

    @PostMapping
    public Floor createFloor(@RequestBody Floor floor){
        return service.createFloor(floor);
    }

    @PostMapping("/param")
    public Floor createFloor(@RequestParam int floorNumber,@RequestParam int elevatorSystemId,@RequestParam String name){
        return service.createFloor(new Floor(new ElevatorFloorKey(elevatorSystemId,floorNumber),name));
    }

    @PutMapping
    public Floor updateFloor(@RequestBody Floor floor){
        return service.updateFloor(floor);
    }

}
