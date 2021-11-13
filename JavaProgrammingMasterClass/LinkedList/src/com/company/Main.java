package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        List<Integer> integerList = new ArrayList<Integer>();

        integerList.add(1);
        integerList.add(3);
        integerList.add(4);

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(i + ": " + integerList.get(i));
        }

        integerList.add(1, 2);

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(i + ": " + integerList.get(i));
        }
    }
}
