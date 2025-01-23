package com.example.Uber.Entity;

import com.example.Uber.Enum.CarType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="Car")
public class Car {

    @Id
    @Column(name="carnumber",unique = true,nullable = false)
    private String carnumber;

    @Column(name="cartype")
    private CarType cartype;

    @Column(name="carname",nullable = false)
    private String carname;


    @OneToOne(mappedBy = "car")
    @JsonManagedReference
    @JsonIgnore
    private Driver driver;


}
