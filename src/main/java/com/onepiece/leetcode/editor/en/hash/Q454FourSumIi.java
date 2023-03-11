//Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, 
//return the number of tuples (i, j, k, l) such that: 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//Output: 2
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics Array Hash Table 👍 4410 👎 127


package com.onepiece.leetcode.editor.en.hash;

import java.util.HashMap;
import java.util.Map;

public class Q454FourSumIi {

    public static void main(String[] args) {
        Solution solution = new Q454FourSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int sum = nums1[i] + nums2[j];
                    map.compute(sum, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
                }
            }
            int cnt = 0;
            for (int i = 0; i < nums3.length; i++) {
                for (int j = 0; j < nums4.length; j++) {
                    int sum = -nums3[i] - nums4[j];
                    if (map.containsKey(sum)) {
                        cnt += map.get(sum);
                    }
                }
            }
            return cnt;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}