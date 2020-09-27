package com.mughees;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMQueue {

    static class Customer {
        int QUEUE_NUMBER;
        int AMOUNT;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            ArrayList<Customer> queue = new ArrayList<>();
            ArrayList<Integer> order = new ArrayList<>();

            int numOfPeople = scanner.nextInt();
            int maxAmount = scanner.nextInt();

            int[] customerMoney = new int[numOfPeople];
            for (int j = 0; j < numOfPeople; j++) {
                customerMoney[j] = scanner.nextInt();
            }

            for (int k = 0; k < numOfPeople; k++) {
                Customer customer = new Customer();
                customer.QUEUE_NUMBER = k + 1;
                customer.AMOUNT = customerMoney[k];
                queue.add(customer);
            }

            while (queue.size() > 0) {
                Customer customer = queue.remove(0);
                customer.AMOUNT -= maxAmount;
                if (customer.AMOUNT > 0) {
                    queue.add(customer);
                } else {
                    order.add(customer.QUEUE_NUMBER);
                }
            }

            System.out.println("\nCase #" + i + ": ");
            for (Integer integer : order) {
                System.out.print(integer + " ");
            }
        }
    }
}