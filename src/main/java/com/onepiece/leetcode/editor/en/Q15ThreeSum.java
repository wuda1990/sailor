//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not mat
//ter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 24543 👎 2219


package com.onepiece.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q15ThreeSum {
    //2023-03-12 14:43:49
    //3Sum
    //编号：[15]
    public static void main(String[] args) {
        Solution solution = new Q15ThreeSum().new Solution();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            //spit the line with coma and convert to int array
            int[] nums = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
            solution.threeSum(nums);
        }
//          solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//          solution.threeSum(new int[]{0, 0, 0});
//          solution.threeSum(new int[]{-2,0,1,1,2});
//        solution.threeSum(new int[]{0, 1, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) {
                    return result;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
