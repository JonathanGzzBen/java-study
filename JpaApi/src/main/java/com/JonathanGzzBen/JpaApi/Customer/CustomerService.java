package com.JonathanGzzBen.JpaApi.Customer;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getCustomers();
    public CustomerDTO findCustomerById(Long customerId);
    public CustomerDTO addNewCustomer(Customer customer);
    public void deleteCustomer(Long customerId);
    public CustomerDTO updateCustomer(Long customerId, String firstName, String lastName);
}
