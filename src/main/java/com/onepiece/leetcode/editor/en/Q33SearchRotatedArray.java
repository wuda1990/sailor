package com.onepiece.leetcode.editor.en;

public class Q33SearchRotatedArray {

    public static void main(String[] args) {
        Solution solution = new Q33SearchRotatedArray().new Solution();
        System.out.println(solution.search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 3));
        System.out.println(solution.search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 5));
        System.out.println(solution.search(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 9));
        System.out.println(solution.search(new int[]{5, 1, 3}, 5));
    }

    class Solution {

        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[low] < nums[high]) {
                    if (nums[mid] > target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else { // 45670123,56701234,67012345,
                    // low,mid,high,target
                    // 45670123，low<mid,low>high
                    if (nums[mid] >= nums[low]) {
                        if (nums[low] <= target && target < nums[mid]) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    } else { // 56701234，mid<high,high<low
                        if (nums[mid] < target && target <= nums[high]) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
