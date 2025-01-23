package com.example.Uber.Dto.Responce;

import com.example.Uber.Entity.Car;
import com.example.Uber.Entity.Driver;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingResponce {

    private int booking_id;
    private Driver driver;
    private Car car;
   private  Double price;
}
