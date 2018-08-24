package com.nowcoder.algorithms;

public class SelectSort extends BaseSort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i)
                swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        sort.testSort(new int[]{2, 3, 9, 6, 7, 11, 1, 0, 8, 5});
    }
}
