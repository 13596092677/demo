package com.liuyuyao.myproject.demo.重复的DNA序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/22 3:45 下午
 * @description：
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        Set<Integer> exist = new HashSet<>();
        int status = 0;
        for (int i = 0; i < 10; i = i + 1) {
            switch (s.charAt(i)) {
                case 'A':
                    status |= 0 << i * 2;
                    break;
                case 'C':
                    status |= 1 << i * 2;
                    break;
                case 'G':
                    status |= 2 << i * 2;
                    break;
                case 'T':
                    status |= 3 << i * 2;
                    break;
            }
        }
        exist.add(status);
        int i = 1, j = i + 10;
        while (i < s.length() && j <= s.length()) {
            status >>= 2;
            switch (s.charAt(j - 1)) {
                case 'A':
                    status |= 0 << 18;
                    break;
                case 'C':
                    status |= 1 << 18;
                    break;
                case 'G':
                    status |= 2 << 18;
                    break;
                case 'T':
                    status |= 3 << 18;
                    break;
            }
            if (exist.contains(status)) {
                if (!ans.contains(s.substring(i, j))) {
                    ans.add(s.substring(i, j));
                }
            } else{
                exist.add(status);
            }
            i++;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(res);
    }
}
