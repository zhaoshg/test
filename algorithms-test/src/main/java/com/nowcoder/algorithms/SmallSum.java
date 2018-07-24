package com.nowcoder.algorithms;

import java.util.Arrays;

/**
 * 在一个数组中， 当前元素的左边,每个比当前元素小的数累加起来，叫做这个元素的小和,每个元素的小和累加起来,就叫做这个数组的小和。 求一个数组
 * 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数， 无
 * 3左边比3小的数， 1
 * 4左边比4小的数， 1 3
 * 2左边比2小的数， 1
 * 5左边比5小的数， 1 3 4 2
 * 所以小和为1+1+3+1+1+3+4+2=16
 * <p>
 * <p>
 * <p>
 * 可以把求小和的过程,放到归并排序中.
 * 归并排序中,每一次merge,都会把两个数组中较小的数,填入辅助数组,那么,这个比较小的数,就是数组小和的一份子
 */
public class SmallSum extends BaseSort {
    @Override
    public void sort() {
        if (arr.length < 2) {
            return;
        }

        int res = mergeSort(0, arr.length - 1);
        System.out.println("小和 = " + res);
    }

    private int mergeSort(int l, int r) {
        if (l == r)
            return 0;
        int mid = l + ((r - l) >> 1);
        return mergeSort(l, mid) + mergeSort(mid + 1, r) + merge(l, mid, r);
    }

    private int merge(int l, int m, int r) {
        //打印,帮助理解
        System.out.print("{left=" + l + " , mid=" + m + ", right=" + r + "}");
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        System.arraycopy(arr, l, left, 0, m - l + 1);
        System.arraycopy(arr, m + 1, right, 0, r - m);
        System.out.println("此时[" + Arrays.toString(left) + "] 和 [" + Arrays.toString(right) + "] 进行merge操作");

        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        //这个是小和
        int res = 0;
        //开始排
        while (p1 <= m && p2 <= r) {
            //如果arr[p1] 比 arr[p2]小,那么arr[p1]就是arr[p2]以及它后面所有元素的小和原子之一 :  小和 += (r-p2+1)*arr[p1]
            //如果arr[p1] 比 arr[p2]大,那么arr[p1]针对它右侧的所有数,都不产生小和变化
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}
