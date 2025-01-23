package com.example.Uber.Controller;

import com.example.Uber.Dto.Request.BookingRequest;
import com.example.Uber.Dto.Responce.BookingResponce;
import com.example.Uber.Entity.Booking;
import com.example.Uber.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uber/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/")
    public ResponseEntity<BookingResponce> create(@RequestBody BookingRequest bookingRequest){

        BookingResponce bookingResponce=bookingService.create(bookingRequest);


        return new ResponseEntity<>(bookingResponce, HttpStatus.OK);

    }
}
