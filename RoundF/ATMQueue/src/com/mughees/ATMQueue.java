package com.mughees;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMQueue {

    static class Person {
        int Number;
        int Amount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            ArrayList<Person> queue = new ArrayList<>();
            ArrayList<Integer> order = new ArrayList<>();

            int numOfPeople = scanner.nextInt();
            int maxAmount = scanner.nextInt();

            int[] customerMoney = new int[numOfPeople];
            for (int j = 0; j < numOfPeople; j++) {
                customerMoney[j] = scanner.nextInt();
            }

            for (int k = 0; k < numOfPeople; k++) {
                Person p = new Person();
                p.Number = k + 1; // add 1 to account array index 0
                p.Amount = customerMoney[k];
                queue.add(p);
            }

            while (queue.size() > 0) {
                Person p = queue.remove(0);
                p.Amount -= maxAmount;
                if (p.Amount > 0) {
                    queue.add(p);
                } else {
                    order.add(p.Number);
                }
            }

            System.out.println("\nCase #" + i + ": ");
            for (Integer integer : order) {
                System.out.print(integer);
                System.out.print(" ");
            }
        }
    }
}
