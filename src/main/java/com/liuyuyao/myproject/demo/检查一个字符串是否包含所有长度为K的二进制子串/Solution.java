package com.liuyuyao.myproject.demo.检查一个字符串是否包含所有长度为K的二进制子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/22 11:43 下午
 * @description：
 */
public class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int mask = 0;
        for (int i = 0; i < k; i++) {
            mask |= s.charAt(i)-'0' << i;
        }
        Set<Integer> set = new HashSet<>();
        set.add(mask);
        int i = 1, j = k + 1;
        while (j <= s.length()) {
            mask >>= 1;
            mask |= s.charAt(j - 1) - '0' << k - 1;
            set.add(mask);
            i++;
            j++;
        }
        for (i = 0; i < 1 << k; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.hasAllCodes("0110", 2);
        System.out.println(res);
    }
}
