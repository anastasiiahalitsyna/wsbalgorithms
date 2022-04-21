package com.anastasiia.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        sortWithBubble(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void sortWithBubble(int[] array) {
        for (int a = 0; a < array.length; a++) {
            for (int b = 0; b < array.length - (a + 1); b++) {
                if (array[b] > array[b + 1]) {
                    int temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        }
    }


}

