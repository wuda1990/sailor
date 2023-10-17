package com.onepiece.niuke;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    //string only include (){}[], return the string is valid or not
    public boolean isValid(String string) {
        //use Stack
        Deque<Character> stack = new LinkedList<>();
        for (char c : string.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            //if stack is empty or c is not equal to stack.pop(), return false
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String string = "(){[]";
        boolean ans = solution.isValid(string);
        System.out.println(ans);
    }
}
