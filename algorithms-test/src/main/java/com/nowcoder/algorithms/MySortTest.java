package com.nowcoder.algorithms;

public class MySortTest {

    public static void main(String[] args) {
        int[] arr = {2, 0, 9, 6, 7, 1, 3};
        OptimizedQuickSort oqs = new OptimizedQuickSort();
        oqs.checkin(5, 80, 100);
        HeapSort hs = new HeapSort();
        hs.checkin(5, 80, 100);
    }


    /**
     * 求一个数组中的最大值,用递归实现
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    static int max(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int maxLeft = max(arr, left, mid);
        int maxRight = max(arr, mid + 1, right);
        return Math.max(maxLeft, maxRight);
    }

}
