package com.study.elevatordesign.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private int elevatorSystemId;

    private int fromFloor;

    private int toFloor;

    private int numberOfPersons;

    private String direction;
}
