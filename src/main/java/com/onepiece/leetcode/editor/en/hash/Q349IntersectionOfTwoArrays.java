//Given two integer arrays nums1 and nums2, return an array of their intersectio
//n. Each element in the result must be unique and you may return the result in an
//y order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics Array Hash Table Two Pointers Binary Search Sorting 
// 👍 4398 👎 2090


package com.onepiece.leetcode.editor.en.hash;

import java.util.LinkedList;
import java.util.List;

public class Q349IntersectionOfTwoArrays {

    //2023-03-09 21:36:55
    //Intersection of Two Arrays
    //编号：[349]
    public static void main(String[] args) {
        Solution solution = new Q349IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            int[] resultMap = new int[1001];
            int[] map = new int[1001];
            for (int i : nums1) {
                map[i] = 1;
            }
            for (int j : nums2) {
                if (map[j] == 1) {
                    resultMap[j] = 1;
                }
            }
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < resultMap.length; i++) {
                if (resultMap[i] == 1) {
                    list.add(i);
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
