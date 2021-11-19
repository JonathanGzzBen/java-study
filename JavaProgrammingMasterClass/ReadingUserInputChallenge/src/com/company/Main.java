package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int validNumbersCount = 0;
        int totalSum = 0;
        while (validNumbersCount < 10) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number #" + (validNumbersCount + 1) + ":");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                totalSum += scanner.nextInt();
                scanner.nextLine();
                validNumbersCount++;
            } else {
                System.out.println("Invalid Number");
            }
        }
        System.out.println("The total sum is " + totalSum);
    }
}
