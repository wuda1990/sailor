//<p>给定两个整数 <code>n</code> 和 <code>k</code>，返回范围 <code>[1, n]</code> 中所有可能的 <code>k</code> 个数的组合。</p>
//
//<p>你可以按 <strong>任何顺序</strong> 返回答案。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 4, k = 2
//<strong>输出：</strong>
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1, k = 1
//<strong>输出：</strong>[[1]]</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= n <= 20</code></li>
//	<li><code>1 <= k <= n</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 733</li><li>👎 0</li></div>
  
package com.onepiece.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations{
  public static void main(String[] args) {
       Solution solution = new Combinations().new Solution();
      solution.combine(4, 2);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(1, n, k, list, result);
        return result;
    }

      private void backTrack(int start, int n, int k, List<Integer> list, List<List<Integer>> result) {
          if (list.size() == k) {
              result.add(new ArrayList<>(list));
              return;
          }
          //这里for循环的终止条件需要剪枝
          for (int i = start; i <= n+1-(k-list.size()); i++) {
              list.add(i);
              backTrack(i + 1, n, k, list, result);
              list.remove(list.size() - 1);
          }

      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}