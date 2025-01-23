package com.example.Uber.Service;

import com.example.Uber.Dto.Request.CustomerRequest;
import com.example.Uber.Entity.Customer;
import com.example.Uber.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(CustomerRequest customerRequest){
        if(customerRequest==null){
            return null;
        }
      Customer customer=new Customer();
      customer.setCustomer_name(customerRequest.getCustomer_name());
      customer.setMail(customerRequest.getMail());
      customer.setPhone_number(customerRequest.getPhone_number());

      return customerRepository.save(customer);

    }
    public Optional<Customer> findById(int id){
        return customerRepository.findById(id);
    }
}
