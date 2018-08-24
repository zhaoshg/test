package com.nowcoder.algorithms;

/**
 * 插入法,要点是:
 * 1. 数组第一个数是有序的
 * 2. 后面的数,和有序数组比较,当不满足条件时即可停止,因为前面是有序的,再往前找,肯定都是不满足条件的.
 * <p>
 * O(n^2)
 */
public class InsertSort extends BaseSort {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }


    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        sort.testSort(new int[]{2, 3, 9, 6, 7, 11, 1, 0, 8, 5});
    }
}
