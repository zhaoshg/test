package com.nowcoder.algorithms;

public class MySortTest {

    public static void main(String[] args) {
//        BubbleSort bs = new BubbleSort();
//        bs.checkin(0, 50, 100);
//
//        InsertSort is = new InsertSort();
//        is.checkin(0, 50, 100);
//
//        SelectSort ss = new SelectSort();
//        ss.checkin(0, 50, 100);
        int[] arr = {2,3,9,6,7,1,0,11,23,45,15,35};
        System.out.println(max(arr,0,arr.length-1));

    }


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
