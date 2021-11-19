package com.JonathanGzzBen.JpaApi.Customer;

public class CustomerMapper {
    public static CustomerDTO toCustomerDto(Customer customer) {
        return new CustomerDTO()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName());
    }
}
