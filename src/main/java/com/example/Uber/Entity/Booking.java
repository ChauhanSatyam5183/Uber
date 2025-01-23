package com.example.Uber.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Booking")

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingid;


    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;



    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;



    @Column(name="PickupLoc",nullable = false)
    private String pickupLoc;

    @Column(name="dropLoc",nullable = false)
    private String dropLoc;


    @Column(name="start_time")
    private LocalTime startTime;

    @Column(name="end_time")
    private LocalTime endTime;

    @Column(name="price",nullable = false)
    private Double price;






}
