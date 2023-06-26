package com.onepiece.algorithm;

import java.util.Arrays;

public class HeapSort2 {

    private int[] arr;

    public HeapSort2(int[] arr) {
        this.arr = arr;
    }

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort() {
        /*
         *  第一步：将数组堆化
         *  heapifyBegin = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int lastIndex = arr.length - 1;
        int heapifyBegin = lastIndex >> 1;
        for (int i = heapifyBegin; i >= 0; i--) {
            maxHeapify(i, lastIndex);
        }

        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for (int i = lastIndex; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private void maxHeapify(int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。

        if (li > len) {
            return;       // 左子节点索引超出计算范围，直接返回。
        }
        if (ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
        {
            cMax = ri;
        }
        if (arr[cMax] > arr[index]) {
            swap(cMax, index);      // 如果父节点被子节点调换，
            maxHeapify(cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    /**
     * @param k: the Kth largest element in array
     * @return
     */
    public int findKthLargest(int k) {
        //数组堆化
        int lastIndex = arr.length - 1;
        int heapifyBegin = lastIndex >> 1;
        for (int i = heapifyBegin; i >= 0; i--) {
            maxHeapify(i, lastIndex);
        }
        //堆化操作k-1次，此时堆顶就是第k大的元素
        for (int i = 0; i < k - 1; i++) {
            //第0个元素最大，交换到尾部，类似选择排序
            swap(0, lastIndex - i);
            maxHeapify(0, lastIndex - 1 - i);
        }
        return arr[0];
    }

    /**
     * 测试用例
     * <p>
     * 输出： [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9]
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new HeapSort2(arr).sort();
        System.out.println(Arrays.toString(arr));

        // test findKthLargest
        int kthLargest = new HeapSort2(new int[]{3, 7, 87, 66, 5, 69, 22}).findKthLargest(1);
        System.out.println(kthLargest);
    }
}