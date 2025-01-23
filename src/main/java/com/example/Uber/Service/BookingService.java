package com.example.Uber.Service;

import com.example.Uber.Dto.Request.BookingRequest;
import com.example.Uber.Dto.Responce.BookingResponce;
import com.example.Uber.Entity.Booking;
import com.example.Uber.Entity.Customer;
import com.example.Uber.Entity.Driver;
import com.example.Uber.Enum.CarType;
import com.example.Uber.Interface.Notification;
import com.example.Uber.repository.BookingRepository;
import com.example.Uber.repository.CustomerRepository;
import com.example.Uber.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;



    @Autowired
    private Notification notification;


    @Autowired
    private DriverService driverService;


    @Autowired
    private CustomerService customerService;


    @Autowired
    private PriceCalculatorService priceCalculatorService;

    public BookingResponce create(BookingRequest bookingRequest){
        Optional<Driver> driver = driverService.findById(bookingRequest.getDriver_id());
        if(driver==null){
            return null;
        }

        Optional<Customer>customer = customerService.findById(bookingRequest.getCustomer_id());
        if(customer==null){
            return null;
        }



        Booking booking = Booking.builder()
                .driver(driver.get())  // Set the driver
                .customer(customer.get())  // Set the customer
                .pickupLoc(bookingRequest.getPickupLoc())
                .dropLoc(bookingRequest.getDropLoc())
                .startTime(LocalTime.now())
                .endTime(LocalTime.NOON)
                .build();



     double new_price=priceCalculatorService.getPrice(bookingRequest.getPickupLoc(),bookingRequest.getDropLoc(),booking.getDriver().getCar().getCartype());


     booking.setPrice(new_price);

     Booking booking1= bookingRepository.save(booking);

     //Notification
        System.out.println(Thread.currentThread());
       notification.sendnotification();
        System.out.println(Thread.currentThread());



        return BookingResponce.builder()
                .driver(booking1.getDriver())
                .car(booking1.getDriver().getCar())
                .booking_id(booking1.getBookingid())
               .price(new_price)
                .build();
    }



}
