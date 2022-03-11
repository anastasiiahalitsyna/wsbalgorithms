package com.anastasiia.exam1;

import java.util.ArrayList;
import java.util.List;

public class TwoArrayComparison {

    public static void main(String[] args) {
        int[] nums1 = {99, -10, 100123, 5, -978, 5623, 463, -9, 287, 50};
        int[] nums2 = {-10, 100123, 18, -978, 5624, 463, -9, 287, 49};

        sortWithSelectionAsc(nums1);
        sortWithSelectionAsc(nums2);

        List<Integer> numsOnlyInNums1 = new ArrayList<>();
        List<Integer> numsOnlyInNums2 = new ArrayList<>();
        List<Integer> commonNums = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            int searchResult = findIndexWithBinarySearch(nums2, nums1[i]);
            if (searchResult == -1) {
                numsOnlyInNums1.add(nums1[i]);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            int searchResult = findIndexWithBinarySearch(nums1, nums2[i]);
            if (searchResult == -1) {
                numsOnlyInNums2.add(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            int searchResult = findIndexWithBinarySearch(nums2, nums1[i]);
            if (searchResult >= 0) {
                commonNums.add(nums1[i]);
            }
        }


        System.out.println(numsOnlyInNums1);
        System.out.println(numsOnlyInNums2);
        System.out.println(commonNums);
    }

    public static int findIndexWithBinarySearch(int[] targetArr, int searchingFor) {
        int leftCursor = 0, rightCursor = targetArr.length - 1;

        while (leftCursor <= rightCursor) {
            int middleCursor = leftCursor + (rightCursor - leftCursor) / 2;

            if (targetArr[middleCursor] == searchingFor) {
                return middleCursor;
            }
            if (targetArr[middleCursor] < searchingFor) {
                leftCursor = middleCursor + 1;
            } else {
                rightCursor = middleCursor - 1;
            }
        }
        return -1;
    }


    public static void sortWithSelectionAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
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
