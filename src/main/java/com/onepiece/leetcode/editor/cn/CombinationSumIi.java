//<p>给定一个数组 <code>candidates</code> 和一个目标数 <code>target</code> ，找出 <code>candidates</code> 中所有可以使数字和为 <code>target</code> 的组合。</p>
//
//<p><code>candidates</code> 中的每个数字在每个组合中只能使用一次。</p>
//
//<p><strong>注意：</strong>解集不能包含重复的组合。 </p>
//
//<p> </p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> candidates = <code>[10,1,2,7,6,1,5]</code>, target = <code>8</code>,
//<strong>输出:</strong>
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> candidates = [2,5,2,1,2], target = 5,
//<strong>输出:</strong>
//[
//[1,2,2],
//[5]
//]</pre>
//
//<p> </p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 <= candidates.length <= 100</code></li>
//	<li><code>1 <= candidates[i] <= 50</code></li>
//	<li><code>1 <= target <= 30</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 706</li><li>👎 0</li></div>
  
package com.onepiece.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi{
  public static void main(String[] args) {
       Solution solution = new CombinationSumIi().new Solution();
      solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,0, list, target,result);
        return result;
    }
//[1, 1, 2, 5, 6, 7, 10]
    private void backTrack(int[] candidates,int pos, List<Integer> list, int target,List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTrack(candidates, i + 1, list, target - candidates[i], result);
            list.remove(list.size() - 1);
        }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}