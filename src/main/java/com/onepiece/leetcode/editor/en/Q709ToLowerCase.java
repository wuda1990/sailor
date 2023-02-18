//Given a string s, return the string after replacing every uppercase letter wit
//h the same lowercase letter. 
//
// 
// Example 1: 
//
// 
//Input: s = "Hello"
//Output: "hello"
// 
//
// Example 2: 
//
// 
//Input: s = "here"
//Output: "here"
// 
//
// Example 3: 
//
// 
//Input: s = "LOVELY"
//Output: "lovely"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of printable ASCII characters. 
// 
// Related Topics String 
// 👍 1464 👎 2576


  package com.onepiece.leetcode.editor.en;
  public class Q709ToLowerCase{
 //2023-02-18 20:35:04
    //To Lower Case
    //编号：[709]
      public static void main(String[] args) {
           Solution solution = new Q709ToLowerCase().new Solution();
          System.out.println(solution.toLowerCase("AdAdJ"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
