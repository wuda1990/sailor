package com.onepiece.algorithm;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 10, 2, 4, 5};
        System.out.println(findK(nums, 2));
        System.out.println(findK(nums, 8));
        System.out.println(findK(nums, 3));
        System.out.println(findK(nums, 4));
    }

    /**
     * 一个循环升序数组，找到整数k的位置，不存在就返回-1；例如，8，9，10，2，4，5， k=2 返回3，k=1,返回-1
     * 1,3,5,7,9
     * 10,12,3,5,7,9
     *
     * @param nums
     * @param k
     * @return
     */
    private static int findK(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (k == nums[mid]) {
                return mid;
            }
            if (nums[mid] <= nums[l]) {//右边为递增顺序
                if (k > nums[mid] && nums[mid] < nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > nums[l]) {//左边为递增顺序
                if (k >= nums[l] && k < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;

    }
}
