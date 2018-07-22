package com.nowcoder.algorithms;

public class InsertSort extends SortBase {

    @Override
    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(j, j + 1);
            }
        }
    }
}
