package com.example.Uber.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Builder
@Table(name="Driver")
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="name",nullable = false)
     private String name;

    @Column(name="adhaarNumber", nullable = false,unique = true)
    private String adhaarNumber;


    @Column(name="phone",unique = true)
    private String phone;


//
//    @Column(name="active")
//    private boolean active;

    //relation
//    car to driver

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "carnumber", referencedColumnName = "carnumber")
    private Car car;


    //relation with booking
    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    List<Booking>booking=new ArrayList<>();



}
