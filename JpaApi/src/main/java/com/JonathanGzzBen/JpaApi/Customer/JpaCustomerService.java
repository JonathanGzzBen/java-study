package com.JonathanGzzBen.JpaApi.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaCustomerService implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public JpaCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        var customerDTOS = new ArrayList<CustomerDTO>();
        customerRepository.findAll().forEach(c -> {
            customerDTOS.add(CustomerMapper.toCustomerDto(c));
        });
       return customerDTOS;
    }

    @Override
    public CustomerDTO findCustomerById(Long customerId) {
        return null;
    }

    @Override
    public CustomerDTO addNewCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {

    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, String firstName, String lastName) {
        return null;
    }
}
