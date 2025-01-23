package com.example.Uber.Controller;

import com.example.Uber.Dto.Request.CustomerRequest;
import com.example.Uber.Entity.Customer;

import com.example.Uber.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uber/v1/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public String create(@RequestBody CustomerRequest CustomerRequest){


        Customer customer= customerService.create(CustomerRequest);

       if(customer!=null){
           return "created login";
        }
       return null;
    }
}
