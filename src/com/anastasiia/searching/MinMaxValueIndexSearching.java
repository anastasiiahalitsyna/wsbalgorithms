package com.anastasiia.searching;

public class MinMaxValueIndexSearching {


    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 2, 9, 5, 7, 7, 12, 334, 5, 0, -23};
        System.out.println(findMinMaxValue(arr, true));
        System.out.println(findMinMaxValue(arr, false));
        System.out.println(findMinMaxIndex(arr, true));
        System.out.println(findMinMaxIndex(arr, false));
    }


    public static int findMinMaxValue(int[] targetArray, boolean shouldFindMin) {
        if (targetArray == null || targetArray.length == 0) {
            return -1;
        }
        int result = targetArray[0];

        for (int element : targetArray) {
            if (shouldFindMin) {
                result = Math.min(result, element);
            } else {
                result = Math.max(result, element);
            }
        }
        return result;
    }


    public static int findMinMaxIndex(int[] targetArray, boolean shouldFindMin) {
        if (targetArray == null || targetArray.length == 0) {
            return -1;
        }

        int element = targetArray[0];
        int index = 0;
        for (int i = 0; i < targetArray.length; i++) {
            if (shouldFindMin) {
                if (targetArray[i] < element) {
                    element = targetArray[i];
                    index = i;
                }
            } else {
                if (targetArray[i] > element) {
                    element = targetArray[i];
                    index = i;
                }
            }
        }
        return index;
    }
}


