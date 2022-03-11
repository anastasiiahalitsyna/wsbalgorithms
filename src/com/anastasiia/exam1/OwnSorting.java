package com.anastasiia.exam1;

import java.util.Arrays;

public class OwnSorting {

    public static void main(String[] args) {
        int[] nums = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void sort(int[] array) {
        for (int a = 0; a < array.length; a++) {
            for (int b = 0; b < array.length - (a + 1); b++) {
                if (array[b] > array[b + 1]) {
                    array[b + 1] += array[b];
                    array[b] = array[b + 1] - array[b];
                    array[b + 1] -= array[b];
                }
            }
        }
    }
}

