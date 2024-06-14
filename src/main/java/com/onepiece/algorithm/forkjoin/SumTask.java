package com.onepiece.algorithm.forkjoin;

import java.util.concurrent.RecursiveTask;

// A RecursiveTask to sum an array of integers
class SumTask extends RecursiveTask<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 100) { // Threshold for sequential processing
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = start + (end - start) / 2;
            SumTask left = new SumTask(array, start, mid);
            SumTask right = new SumTask(array, mid, end);

            left.fork(); // Fork left sub-task
            int rightResult = right.compute(); // Compute right sub-task (in this thread)
            int leftResult = left.join(); // Join and get the result of the left sub-task

            return leftResult + rightResult; // Combine results
        }
    }
}



