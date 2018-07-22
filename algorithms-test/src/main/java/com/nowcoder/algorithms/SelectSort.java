package com.nowcoder.algorithms;

public class SelectSort extends SortBase {

    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i)
                swap(i, min);
        }
    }
}
