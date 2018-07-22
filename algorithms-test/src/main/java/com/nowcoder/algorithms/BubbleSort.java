package com.nowcoder.algorithms;

public class BubbleSort extends SortBase {
    @Override
    public void sort() {
        if (arr.length < 2)
            return;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j,j+1);
                }
            }
        }
    }


}
