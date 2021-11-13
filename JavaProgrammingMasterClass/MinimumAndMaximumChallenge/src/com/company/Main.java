package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int minimumNumber = Integer.MAX_VALUE;
        int maximumNumber = Integer.MIN_VALUE;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number: ");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int nextInt = scanner.nextInt();
                scanner.nextLine();

                if (nextInt < minimumNumber)
                    minimumNumber = nextInt;

                if (nextInt > maximumNumber)
                    maximumNumber = nextInt;
            } else {
                break;
            }
        }
        System.out.println("Minimum Number: " + minimumNumber);
        System.out.println("Maximum Number: " + maximumNumber);
    }
}
