package com.nowcoder.algorithms;

/**
 * 大根堆排序:
 * 首先利用数组的0~i创建大根堆.
 * 大根堆建完之后,把最后的一个数,与堆顶元素交换,堆长度--,交换到堆顶的元素下沉
 * 依次进行
 */
public class HeapSort extends BaseSort {


    @Override
    public void sort() {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(i);
        }
        int size = arr.length;
        swap(0, --size);
        while (size > 0) {
            heapify(0, size);
            swap(0, --size);
        }
    }

    /**
     * 堆化,检查第index个元素,如果不满足大根堆条件,则调整它(该元素下沉),知道满足大根堆条件.
     *
     * @param index 要检查的元素
     * @param size  堆长度
     */
    private void heapify(int index, int size) {
        //TODO 元素下沉
        int left = index * 2 + 1;
        while (left < size) {
            // 获取当前下标节点的左右分支的最大值
            // 如果index的右分支存在,并且右分支大于左分支,那么左右分支的最大值就是右分支,否则就是左分支
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //再把左右孩子中最大的与index相比,取最大值的下标.
            largest = arr[largest] > arr[index] ? largest : index;
            //如果index就是最大的,那么该堆满足大根堆条件,就跳出.
            if (largest == index)
                break;
            //不满足,就把index和largest的元素交换
            swap(index, largest);
            //当前下标来到原先larget的位置
            index = largest;
            //然后计算当前下标的left,继续循环
            left = index * 2 + 1;
        }


    }

    /**
     * 创建大根堆,塞入第i个值
     *
     * @param index
     */
    private void heapInsert(int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
