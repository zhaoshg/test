package com.nowcoder.algorithms;

import java.util.Arrays;

/**
 * 在一个数组中， 左边的数如果比右边的数大， 则折两个数构成一个逆序对， 请打印所有逆序
 * 对。
 * <p>
 * 这个和小和刚好相反,所以还是用归并算法.
 */
public class ReversedPair extends BaseSort {
    @Override
    public void sort() {
        if (arr.length < 2) {
            return;
        }
        System.out.println("需要排序的数组为:" + Arrays.toString(arr));
        mergeSort(0, arr.length - 1);
        System.out.println();
        System.out.println("排序之后的数组为:" + Arrays.toString(arr));
    }

    private void mergeSort(int l, int r) {
        if (l == r)
            return;
        int mid = l + ((r - l) >> 1);
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        merge(l, mid, r);
    }

    private void merge(int l, int m, int r) {
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        System.arraycopy(arr, l, left, 0, m - l + 1);
        System.arraycopy(arr, m + 1, right, 0, r - m);
        System.out.println("此时[" + Arrays.toString(left) + "] 和 [" + Arrays.toString(right) + "] 进行merge操作");
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        //开始排
        while (p1 <= m && p2 <= r) {
            //如果arr[p1]>arr[p2],说明,arr[p1]比arr[p2...r]的所有元素都大,那么都会组成逆序对
            if (arr[p1] > arr[p2]) {
                for (int j = p2; j < r + 1; j++) {
                    System.out.println("[" + arr[p1] + "," + arr[j] + "],");
                }
            }
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        System.arraycopy(help, 0, arr, l, help.length);
    }
}
