package com.nowcoder.algorithms;

/**
 *
 * 冒泡的要点:
 * 每冒一个泡,下次再冒泡的时候,需要把数组长度减一,把已经冒出来的剔除.
 */

public class BubbleSort extends BaseSort {

    @Override
    public void sort() {
        if (arr.length < 2)
            return;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void bubbleSort2() {
        if (arr.length < 2)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length -1 ; j >i ; j--) {
                if (arr[j] < arr[j - 1])
                    swap(j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();

        bs.bubbleSort2();
        bs.printArray();
    }
}