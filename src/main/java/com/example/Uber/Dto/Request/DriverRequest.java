package com.example.Uber.Dto.Request;

import com.example.Uber.Enum.CarType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DriverRequest {


    private String name;


    private String adhaarNumber;


    private String phone;


    private String carnumber;


    private CarType cartype;


    private String carname;


}
