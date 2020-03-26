package com.algorithms;

import com.algorithms.services.search.BinarySearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BinarySearchServiceTest {

    //                    0  1  2   3   4   5   6    7    8    9    10   11   12   13   14
    int [] arrToSearch = {2, 5, 7, 34, 67, 99, 101, 400, 500, 600, 700, 800, 900, 909, 989};


    @Autowired
    BinarySearchService binarySearchService;

    @Test
    public void testBinarySearch() {
        int elemToSearch = 101;
        int index = binarySearchService.binarySearch(arrToSearch, elemToSearch, 0, arrToSearch.length - 1);
        assert index == 6;
        System.out.println("Value:" + arrToSearch[index] + " is at index: " + index);
    }

}
