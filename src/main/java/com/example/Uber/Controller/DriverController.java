package com.example.Uber.Controller;

import com.example.Uber.Dto.Request.DriverRequest;
import com.example.Uber.Dto.Responce.DriverResponse;
import com.example.Uber.Entity.Driver;
import com.example.Uber.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uber/v1/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/")
    public Driver create(@RequestBody DriverRequest driverrequest){
        return driverService.save(driverrequest);
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DriverResponse> getDriverById(@PathVariable int id) {
        DriverResponse driver = driverService.getDriverById(id);
        if(driver!=null){
        return new ResponseEntity<>(driver, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
