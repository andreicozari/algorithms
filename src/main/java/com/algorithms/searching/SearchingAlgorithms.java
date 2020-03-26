package com.algorithms.searching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchingAlgorithms {

    private static int valueToSearch = 400;
    private static int count = 0;

    public static void main(String[] args) {
        SpringApplication.run(SearchingAlgorithms.class, args);
        //                    0  1  2   3   4   5   6    7    8    9    10   11   12   13   14
        int [] arrToSearch = {2, 5, 7, 34, 67, 99, 101, 400, 500, 600, 700, 800, 900, 909, 989};
        int index = binarySearch(arrToSearch, 0, arrToSearch.length - 1);
        System.out.println("Value:" + arrToSearch[index] + " is at index: " + index);
    }

    public static int binarySearch(int [] arr, int left, int right) {
        System.out.println("Step: " + ++count);

        int middle = (right + left) / 2;

        if (valueToSearch == arr[middle]) {
            return middle;
        }

        if ( arr[middle] < valueToSearch ) {
            return binarySearch(arr, middle + 1, right);
        }

        if ( arr[middle] > valueToSearch ) {
            return binarySearch(arr, left, middle - 1);
        }

        return -1;
    }

}
