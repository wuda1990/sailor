//<p>给你一个整数数组 <code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的子集（幂集）。</p>
//
//<p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,2,3]
//<strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0]
//<strong>输出：</strong>[[],[0]]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= nums.length <= 10</code></li>
//	<li><code>-10 <= nums[i] <= 10</code></li>
//	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
//</ul>
//<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1348</li><li>👎 0</li></div>
  
package com.onepiece.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
  public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
      int[] nums = new int[]{1, 2, 3};
      List<List<Integer>> result = solution.subsets(nums);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSets = new ArrayList<>();
        backTrace(nums, 0, subSets, result);
        return result;
    }

      private void backTrace(int[] nums, int pos, List<Integer> subSets, List<List<Integer>> result) {
          result.add(new ArrayList<>(subSets));
          for (int i = pos; i < nums.length; i++) {
              subSets.add(nums[i]);
              backTrace(nums, i + 1, subSets, result);
              subSets.remove(subSets.size() - 1);
          }
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}