package com.algorithms.searching.services;

import org.springframework.stereotype.Service;

@Service
public class BinarySearchService {

    private int count = 0;

    public int binarySearch(int [] arr, int valueToSearch, int left, int right) {
        System.out.println("Step: " + ++count);

        int middle = (right + left) / 2;

        if (valueToSearch == arr[middle]) {
            return middle;
        }

        if ( arr[middle] < valueToSearch ) {
            return binarySearch(arr, valueToSearch, middle + 1, right);
        }

        if ( arr[middle] > valueToSearch ) {
            return binarySearch(arr, valueToSearch, left, middle - 1);
        }

        return -1;
    }
}
