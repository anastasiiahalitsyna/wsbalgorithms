package com.anastasiia.sorting;

import java.util.Arrays;

public class SelectionSort {
// sortowanie przez wybieranie
    public static void main(String[] args) {
        int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
        sortWithSelectionAsc(nums);
        System.out.println(Arrays.toString(nums));
    }



    public static void sortWithSelectionAsc(final int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int minElementIndex = i;//ith index is the min
            for (int j = i + 1; j < arr.length; j++) {
                if ( arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
    }
}
