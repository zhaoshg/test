package com.nowcoder.algorithms;

public class MySortTest {

    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 6, 7, 1, 0};
        ReversedPair rp = new ReversedPair();
        rp.setArr(arr);
        rp.sort();
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
