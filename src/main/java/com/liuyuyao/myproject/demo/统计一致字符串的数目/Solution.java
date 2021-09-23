package com.liuyuyao.myproject.demo.统计一致字符串的数目;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/23 5:11 下午
 * @description：
 */
public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int status = 0;
        int ans = 0;
        for (int i = 0; i < allowed.length(); i++) {
            status |= 1 << allowed.charAt(i) - 'a';
        }
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (int j = 0; j < words[i].length(); j++) {
                mask |= 1 << words[i].charAt(j) - 'a';
            }
            if (Integer.bitCount(mask & status) == Integer.bitCount(mask)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"});
        System.out.println(res);
    }
}
