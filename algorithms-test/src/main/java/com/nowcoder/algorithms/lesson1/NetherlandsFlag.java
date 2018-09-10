package com.nowcoder.algorithms.lesson1;

import java.util.Arrays;

/**
 * 荷兰国旗问题:
 * 给定一个数组arr， 和一个数num， 请把小于num的数放在数组的左边， 等于num的数放在数组的中间， 大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)， 时间复杂度O(N)
 * 荷兰国旗问题可以用在优化快速排序中:
 * 原始的快排,每次把数组分成两部分,大于中值和小于等于中值的.
 * |                       |X|
 * |  smaller  X|   bigger   |
 * 然后X不动,再对X左边和右边的数组进行同样的操作.
 * <p>
 * 优化为荷兰国旗问题,那么就不是X不动了,而是整个equ区不动,然后左右同样操作.
 */

public class NetherlandsFlag {

    /**
     * 荷兰国旗
     *
     * @param arr 给定的数组
     * @param l   数组的左界
     * @param r   数组的右界
     * @param num 给定的数
     * @return 边界
     */
    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1;
        int more = r + 1;
        int curr = l;
        while (curr < more) {
            if (arr[curr] < num) {
                swap(arr, ++less, curr++);
            } else if (arr[curr] > num) {
                swap(arr, --more, curr);
            } else {
                curr++;
            }
        }
        return new int[]{less + 1, more - 1};
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 6, 7, 11, 1, 0, 8, 5};
        int[] res = partition(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }


}
