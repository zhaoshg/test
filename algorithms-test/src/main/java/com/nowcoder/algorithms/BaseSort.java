package com.nowcoder.algorithms;

import java.util.Arrays;

public class BaseSort {

    int[] arr = {2, 1, 6, 4, 9, 8, 7, 0};


    public void setArr(int[] arr) {
        this.arr = arr;
    }


    public void sort() {
        return;
    }


    public void swap(int i, int j) {
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
    public void printArray() {
        if (arr == null) {
            return;
        }
        System.out.println(Arrays.toString(arr));
    }
    // for test
    public void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        System.out.println(Arrays.toString(arr));
    }


    public void checkin(int testTime,int maxSize,int maxVal){
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxVal);
            int[] arr2 = copyArray(arr1);
            setArr(arr1);
            sort();
            comparator(arr2);
            if (!isEqual(arr, arr2)) {
                succeed = false;
                printArray(arr);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxVal);
        printArray(arr);
        setArr(arr);
        sort();
        printArray(arr);
    }
}
