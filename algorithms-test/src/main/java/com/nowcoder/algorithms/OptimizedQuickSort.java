package com.nowcoder.algorithms;

import java.util.Stack;

public class OptimizedQuickSort extends ClassicQuickSort {
    @Override
    public void sort() {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort_not_recursion(0, arr.length - 1);
    }

    private void quickSort(int l, int r) {
        if (l < r) {
            swap(l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(l, r);
            quickSort(l, p[0] - 1);
            quickSort(p[1] + 1, r);
        }
    }

    /**
     * 非递归实现
     */
    private void quickSort_not_recursion(int start, int end) {
        Stack<Integer> index = new Stack<>();
        int pivotPos[];
        index.push(start);
        index.push(end);
        while (!index.isEmpty()) {
            end = index.pop();
            start = index.pop();

            pivotPos = partition(start, end);
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


}