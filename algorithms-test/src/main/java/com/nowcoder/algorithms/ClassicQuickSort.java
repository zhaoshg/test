package com.nowcoder.algorithms;

/**
 * 经典快排序
 */
public class ClassicQuickSort extends BaseSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    /**
     * 这个和荷兰国旗问题很像,但是有所优化,因为取的num是数组的最后一个值.这种写法可以省掉一个num变量.
     *
     * @param l
     * @param r
     * @return 返回一个有两个元素的数组res[]:
     * res[0]是equ区间的第一个元素的下标,也就是smaller区间最后一个元素下标+1 即 less+1
     * res[1]是equ区间的最后一个元素的下标,也就是bigger区间的首个元素下标-1 即 more-1 ,
     * 但是优化写法为什么返回more呢?那是因为bigger区间的第一个数,和数组最后一个数交换了,
     * 也就是说,equ区间又往后面移了一位,bigger区间下标原来是[more ... r],交换完就变成了[more+1,r]
     * 那么,equ区间的下标就应该是[less+1,(more+1)-1],所以就是[less+1,more]
     **/
    int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        //arr[r]只做比较,没有移动过,还在最后.
        // 所以它正确的位置,需要和more区域第一个数交换一下
        //| smaller |   equ   |  bigger |num|  (equ == num)
        //| smaller |   equ    num|  bigger |   交换之后变成这样
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }


    /**
     * 这个分区方法和荷兰国旗一样,是比较方便理解的 加入了num和curr
     *
     * @param l
     * @param r
     * @return
     */
    protected int[] partition2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r + 1;
        int num = arr[r];
        int curr = l;
        while (curr < more) {
            if (arr[curr] < num) {
                swap(arr, ++less, curr++);
            } else if (arr[curr] > arr[r]) {
                swap(arr, --more, curr);
            } else {
                curr++;
            }
        }
        return new int[]{less + 1, more - 1};
    }


    public static void main(String[] args) {
        ClassicQuickSort sort = new ClassicQuickSort();
        sort.testSort(new int[]{2, 3, 9, 6, 7, 11, 1, 0, 8, 5});
    }
}
