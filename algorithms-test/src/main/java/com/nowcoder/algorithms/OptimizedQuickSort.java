package com.nowcoder.algorithms;

import java.util.Stack;

/**
 * 优化后的快速排序
 * partition过程,使用荷兰国旗算法
 */
public class OptimizedQuickSort extends ClassicQuickSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort_not_recursion(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * 非递归实现
     */
    private void quickSort_not_recursion(int[] arr, int start, int end) {
        Stack<Integer> index = new Stack<Integer>();
        int pivotPos[];
        index.push(start);
        index.push(end);
        while (!index.isEmpty()) {
            end = index.pop();
            start = index.pop();

            pivotPos = partition(arr, start, end);
            if (start < pivotPos[0] - 1) {
                index.push(start);
                index.push(pivotPos[0] - 1);
            }
            if (end > pivotPos[1] + 1) {
                index.push(pivotPos[1] + 1);
                index.push(end);
            }
        }
    }

    public static void main(String[] args) {
        OptimizedQuickSort sort = new OptimizedQuickSort();
        sort.testSort(new int[]{2, 3, 9, 6, 7, 11, 1, 0, 8, 5});
    }

}