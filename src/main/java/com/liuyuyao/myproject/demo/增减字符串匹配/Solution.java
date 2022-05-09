package com.liuyuyao.myproject.demo.增减字符串匹配;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/9 下午4:37
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.diStringMatch("III");
        System.out.println(res);
    }

    public int[] diStringMatch(String s) {
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            list.add(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = list.get(0);
                list.remove(0);
            } else {
                ans[i] = list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
        ans[s.length()] = list.get(0);
        return ans;
    }
}
