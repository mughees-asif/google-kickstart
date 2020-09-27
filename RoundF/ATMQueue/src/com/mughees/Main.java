package com.mughees;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int numOfPeople = scanner.nextInt();
            int maxAmount = scanner.nextInt();

            int[] customerMoney = new int[numOfPeople];
            for (int j = 0; j < numOfPeople; j++) {
                customerMoney[j] = scanner.nextInt();
            }

            int[] atmQueue = new int[numOfPeople];
            for (int k = 0; k < numOfPeople; k++) {
                atmQueue[k] = k + 1;
            }

            Map<Integer, Double> map = new HashMap<>();
            for (int l = 0; l < numOfPeople; l++) {
                double visits = (double) customerMoney[l] / maxAmount;
                String str = String.format("%1.2f", visits);
                visits = Double.parseDouble(str);
                map.put(l + 1, visits);
            }

            Object[] values = map.values().toArray(new Object[numOfPeople]);
            Object[] sortedArr = Arrays.copyOf(values, values.length);
            Arrays.sort(sortedArr);
            System.out.println(Arrays.toString(values));
            System.out.println(Arrays.toString(sortedArr));

            Object[] result = new Object[numOfPeople];
            for (int m = 0; m < numOfPeople; m++) {
                result[m] = findIndex(values, (Integer) sortedArr[m]);
            }
            System.out.println(Arrays.toString(result));
        }
    }

    public static int findIndex(Object arr[], int t) {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
}
