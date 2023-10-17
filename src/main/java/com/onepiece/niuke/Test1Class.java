package com.onepiece.niuke;

import java.util.HashMap;
import java.util.Map;

public class Test1Class {

    public int maxSubStrLength(String s) {
        // get the max length of non-repeated subsequence of s
        int maxLen = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (i < len && j < len) {
            final char c = s.charAt(i);
            if (map.containsKey(c)) {
                i = Math.max(i + 1, map.get(c));
            } else {
                map.put(c, j);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

}
