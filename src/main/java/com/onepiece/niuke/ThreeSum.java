package com.onepiece.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSums(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            //set left and right
            int left = i + 1;
            int right = nums.length - 1;
            //skip the same value
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //two pointers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //sum > 0, right move left
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    //sum < 0, left move right
                    left++;
                } else {
                    //sum == 0, add to ans
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //skip the same value
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //skip the same value
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //move left and right
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum.threeSums(nums);
        System.out.println(ans);
    }

}
