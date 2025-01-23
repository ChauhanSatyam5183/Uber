package com.example.Uber.Dto.Request;

import com.example.Uber.Entity.Customer;
import com.example.Uber.Entity.Driver;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class BookingRequest {


    private int driver_id;
    private int customer_id;


    private String pickupLoc;
    private String dropLoc;


    private LocalTime startTime;





}
