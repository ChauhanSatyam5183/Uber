package com.example.Uber.Service;

import com.example.Uber.Dto.Request.DriverRequest;
import com.example.Uber.Dto.Responce.DriverResponse;
import com.example.Uber.Entity.Car;
import com.example.Uber.Entity.Customer;
import com.example.Uber.Entity.Driver;
import com.example.Uber.repository.CarRepository;
import com.example.Uber.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    public Driver save(DriverRequest driverrequest) {
        // Create a Car entity based on the incoming request
        Car car = new Car();
        car.setCarnumber(driverrequest.getCarnumber());
        car.setCartype(driverrequest.getCartype());
        car.setCarname(driverrequest.getCarname());

        // Save the car if it's a new car
        carRepository.save(car);

        // Now create the Driver and associate the car with it
        Driver driver = Driver.builder()
                .name(driverrequest.getName())
                .adhaarNumber(driverrequest.getAdhaarNumber())
                .phone(driverrequest.getPhone())
                .car(car)  // Associate the car with the driver
                .build();

        // Save the driver
        return driverRepository.save(driver);

    }

    public DriverResponse getDriverById(int id) {
        Driver driver = driverRepository.getById(id);


        DriverResponse dto = new DriverResponse();
        dto.setName(driver.getName());
        dto.setAdhaarNumber(driver.getAdhaarNumber());
        dto.setPhone(driver.getPhone());

        Car car = driver.getCar();
        if (car != null) {
            dto.setCarnumber(car.getCarnumber());
            dto.setCarname(car.getCarname());
            dto.setCartype(car.getCartype().toString());
        }

        return dto;
    }
    public Optional<Driver> findById(int id){
        return driverRepository.findById(id);
    }
}
