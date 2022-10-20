package com.onepiece.algorithm;

import java.util.Arrays;

/**
 * 默认实现最小堆
 * add,remove,top
 */
public class Heap {

    private int size;

    private int[] heap;

    public static final int defaultCapacity = 16;

    public Heap(int capacity){
        heap = new int[capacity];
    }

    public Heap() {
        heap = new int[defaultCapacity];
    }

    public void add(int t) {
        if (size >= heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = t;
        floatUp(size);
        size++;
    }

    private void floatUp(int i) {
        while (i >= 1) {
            int k = (i - 1) >> 1;
            if (heap[k] <= heap[i]) {
                break;
            }
            swap(heap, k, i);
            i = k;
        }
    }

    private void floatDown(int i) {
        while ((2 * i + 1) < size) {
            int k = 2 * i + 1;
            if (heap[k + 1] < heap[k]) {
                k = k + 1;
            }
            if (heap[k] >= heap[i]) {
                break;
            }
            swap(heap, k, i);
            i = k;
        }
    }

    public void remove() {
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size--;
        floatDown(0);
    }

    private void swap(int[] heap, int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public void print() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(heap[i] + ",");
        }
        System.out.println(heap[size - 1]);
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(3);
        heap.add(7);
        heap.add(29);
        heap.add(11);
        heap.add(15);
        heap.add(4);
        heap.print();
        heap.remove();
        heap.print();
    }

}
