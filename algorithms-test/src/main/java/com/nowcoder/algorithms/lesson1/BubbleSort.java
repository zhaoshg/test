package com.nowcoder.algorithms.lesson1;

import com.nowcoder.algorithms.BaseSort;

/**
 * 冒泡的要点:
 * 每冒一个泡,下次再冒泡的时候,需要把数组长度减一,把已经冒出来的剔除.
 */

public class BubbleSort extends BaseSort {

    @Override
    public void sort(int[] arr) {
        if (arr.length < 2)
            return;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void bubbleSort2(int[] arr) {
        if (arr.length < 2)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        bs.testSort(new int[]{2, 3, 9, 6, 7, 11, 1, 0, 8, 5});
    }
}