package com.liuyuyao.myproject.demo.生成匹配的括号;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/28 上午9:09
 * @description：
 */
public class Solution {
    List[] cache = new List[100];
    public List<String> generateParenthesis(int n) {
        cache[0] = new ArrayList() {
            {
                add("");
            }
        };
        List<String> ans = dfs(n);
        return ans;
    }

    List<String> dfs(int n) {
        List<String> res = new ArrayList<>();
        for (int left = 0; left < n; left++) {
            int right = n - left - 1;
            List<String> res1 = cache[left];
            List<String> res2 = cache[right];
            if (res1 == null) {
                res1 = dfs(left);
            }
            if (res2 == null) {
                res2 = dfs(right);
            }
            for (String str1 : res1) {
                for (String str2 : res2) {
                    res.add("(" + str1 + ")" + str2);
                }
            }
            cache[n] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }
}
