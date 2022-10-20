//<p>将一个给定字符串 <code>s</code> 根据给定的行数 <code>numRows</code> ，以从上往下、从左到右进行 Z 字形排列。</p>
//
//<p>比如输入字符串为 <code>"PAYPALISHIRING"</code> 行数为 <code>3</code> 时，排列如下：</p>
//
//<pre>
//P   A   H   N
//A P L S I I G
//Y   I   R</pre>
//
//<p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：<code>"PAHNAPLSIIGYIR"</code>。</p>
//
//<p>请你实现这个将字符串进行指定行数变换的函数：</p>
//
//<pre>
//string convert(string s, int numRows);</pre>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "PAYPALISHIRING", numRows = 3
//<strong>输出：</strong>"PAHNAPLSIIGYIR"
//</pre>
//<strong>示例 2：</strong>
//
//<pre>
//<strong>输入：</strong>s = "PAYPALISHIRING", numRows = 4
//<strong>输出：</strong>"PINALSIGYAHRPI"
//<strong>解释：</strong>
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "A", numRows = 1
//<strong>输出：</strong>"A"
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= s.length <= 1000</code></li>
//	<li><code>s</code> 由英文字母（小写和大写）、<code>','</code> 和 <code>'.'</code> 组成</li>
//	<li><code>1 <= numRows <= 1000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 1272</li><li>👎 0</li></div>
  
package com.onepiece.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion{
  public static void main(String[] args) {
       Solution solution = new ZigzagConversion().new Solution();
      solution.convert1("PAYPALISHIRING", 3);
  }
  //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 找到解题的钥匙，钥匙是需要提炼的。有时候表面的一些东西去解决，会比较费劲。
     */
    class Solution {
    public String convert1(String s, int numRows) {
        if (numRows == 1) return s;
        InnerListNode head = new InnerListNode(-1,null);
        InnerListNode pre = head;

        int j = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cnt < numRows) {
                if (cnt == 0) {
                    char[] str = new char[numRows];
                    str[cnt] = s.charAt(i);
                    InnerListNode node = new InnerListNode(j++, str);
                    pre.next = node;
                    pre = node;
                } else {
                    char[] val = pre.val;
                    val[cnt] = s.charAt(i);
                }
                cnt++;
            } else if (numRows > 2) {
                char[] str = new char[numRows];
                str[numRows - 2 - cnt % numRows] = s.charAt(i);
                InnerListNode node = new InnerListNode(j++, str);
                pre.next = node;
                pre = node;
                cnt++;
                if ((cnt + 2) % numRows == 0) {
                    cnt = 0;
                }
            } else {
                cnt = 0;
                i--;
            }
        }
        char[][] result = new char[j][numRows];
        InnerListNode p = head.next;
        while (p != null) {
            result[p.col] = p.val;
            p = p.next;
        }

        StringBuilder sb = new StringBuilder();
        for (int i1 = 0; i1 < numRows; i1++) {
            for (int j1 = 0; j1 < j; j1++) {
                if (0 == result[j1][i1]) {
                    continue;
                }
                sb.append(result[j1][i1]);
            }
        }
        return sb.toString();
    }
    class InnerListNode{
        int col;
        char[] val;
        InnerListNode next;
        InnerListNode() {}
        InnerListNode(int col,char[] val) { this.col = col;this.val = val; }
        InnerListNode(char[] val,InnerListNode next) { this.val = val; this.next = next; }
    }

      public String convert(String s, int numRows) {
          if (numRows == 1) return s;
          List<StringBuilder> rows = new ArrayList<>();
          for (int i = 0; i < Math.min(numRows, s.length()); i++) rows.add(new StringBuilder());
          int curRow = 0;
          boolean goingDown = false;
          for (char c : s.toCharArray()) {
              rows.get(curRow).append(c);
              if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
              curRow += goingDown ? 1 : -1;
          }
          StringBuilder ret = new StringBuilder();
          for (StringBuilder row : rows) ret.append(row);
          return ret.toString();
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}