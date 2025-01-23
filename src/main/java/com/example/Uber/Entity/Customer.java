package com.example.Uber.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CustomerId;

    @Column(name="customer_name",nullable = false)
    private String customer_name;

    @Column(name="phone_number",nullable = false,unique = true)
    private String phone_number;

    @Column(name="mail",unique = true)
    private String mail;


   @OneToMany(mappedBy = "customer")
   @JsonIgnore
   List<Booking>booking=new ArrayList<>();
}
