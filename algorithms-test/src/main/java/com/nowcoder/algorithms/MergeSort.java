package com.nowcoder.algorithms;

import java.util.Arrays;

/**
 * 归并排序（递归）
 */
public class MergeSort extends BaseSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }


    /**
     * 递归方式 实现归并排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 外排方式,合并两个有序数组
     *
     * @param l 作下标
     * @param m 中间下标
     * @param r 右下标
     */
    private void merge(int[] arr, int l, int m, int r) {
        //打印,帮助理解
        System.out.print("{left=" + l + " , mid=" + m + ", right=" + r + "}");
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        System.arraycopy(arr, l, left, 0, m - l + 1);
        System.arraycopy(arr, m + 1, right, 0, r - m);
        System.out.println("此时[" + Arrays.toString(left) + "] 和 [" + Arrays.toString(right) + "] 进行merge操作");

        //辅助数组
        int[] help = new int[r - l + 1];
        //辅助数组下标
        int i = 0;
        //第一个数组起始下标
        int p1 = l;
        //第二个数组的起始下标
        int p2 = m + 1;
        //比较两个数组对应下标的数字,谁小,就把谁填入辅助数组,然后对应的下标后移一位
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //上面的循环执行完时,说明肯定有一个数组的下标已经到末尾了,因为(p1 <= m && p2 <= r)这个条件已经不满足了
        //如果p1<=m,说明第一个数组还没消耗完,就把第一个数组剩下的数,全部拷贝到辅助数组去
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }

        //如果p2<=m,说明第二个数组还没消耗完,就把第二个数组剩下的数,全部拷贝到辅助数组去
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //把辅助数组里排好序的数,再覆盖回原数组的[l,l+1,l+2,...,r-1,r]中去
        System.arraycopy(help, 0, arr, l, help.length);
        //打印本次排序结果,帮助理解
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 非递归方式实现归并排序
     */
    public void MergeSort2(int[] arr) {
        System.out.println("需要排序的数组为:" + Arrays.toString(arr));
        //使用非递归的方式来实现归并排序
        int len = arr.length;
        int k = 1;

        while (k < len) {
            MergePass(arr, k, len);
            k *= 2;
        }
    }

    /**
     * MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
     *
     * @param k
     * @param len
     */
    private void MergePass(int[] arr, int k, int len) {
        int i = 0;

        //当i+2k-1(右边界) < len 时 , 从前往后,将2个长度为k的子序列合并为1个,
        while (i + 2 * k - 1 < len) {
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }

        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        //上面的循环结束时,说明最后还剩一些凑不齐2k个元素,但是其中前k个元素上次已经是排好序的,那么就只需要对剩余的(i,i+k-1,len-1)元素进行排列就好
        if (i + k < len) {
            merge(arr, i, i + k - 1, len - 1);
        }

    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.testSort(new int[]{2, 3, 9, 6, 7, 11, 1, 0, 8, 5});
    }

}
