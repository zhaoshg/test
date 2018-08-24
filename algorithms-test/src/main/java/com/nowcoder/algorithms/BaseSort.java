package com.nowcoder.algorithms;

import java.util.Arrays;

public class BaseSort {


    public void sort(int[] arr) {
        return;
    }


    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        System.out.println(Arrays.toString(arr));
    }


    public void checkin(int testTime, int maxSize, int maxVal) {
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxVal);
            int[] arr2 = copyArray(arr1);
            sort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxVal);
        printArray(arr);
        sort(arr);
        printArray(arr);
    }


    public void testSort(int[] arr) {
        if (arr == null) {
            arr = generateRandomArray(50, 50);
        }
        System.out.println("Before sort: ");
        printArray(arr);
        sort(arr);
        System.out.println("after sort: ");
        printArray(arr);

    }
}
