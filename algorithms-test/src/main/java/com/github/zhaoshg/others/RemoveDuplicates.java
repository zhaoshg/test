package com.github.zhaoshg.others;

/**
 * 删除有序数组中重复数字
 *
 * 采用快慢指针法，如果fast指针和slow指针的前一个数不一样，则把fast指针指向数字移动到slow位置。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 9};
        removeDuplicates(arr);
    }


    public static void removeDuplicates(int[] arr) {

        int slow = 1, fast;
        for (fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow - 1]) {
                arr[slow++] = arr[fast];
            }
        }
        for (int i = 0; i < slow; i++) {
            System.out.print(arr[i] + ",");
        }

    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
