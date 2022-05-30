package com.liuyuyao.myproject.demo.括号的分数;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/28 上午10:38
 * @description：
 */
public class Solution {
    Map<String, Integer> cache = new HashMap<>();
    public int scoreOfParentheses(String s) {
        cache.put("", 0);
        cache.put("()", 1);
        int ans = dfs(s);
        return ans;
    }

    int dfs(String s){
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else{
                int top = stack.pop();
                if (stack.isEmpty()) {
                    if (i - top == 1) {
                        ans += 1;
                        Integer value = cache.get(s.substring(i + 1));
                        if (value == null) {
                            value = dfs(s.substring(i + 1));
                        }
                        ans += value;
                    } else{
                        Integer value1 = cache.get(s.substring(top + 1, i));
                        Integer value2 = cache.get(s.substring(i + 1));
                        if (value1 == null) {
                            value1 = dfs(s.substring(top + 1, i));
                        }
                        if (value2 == null) {
                            value2 = dfs(s.substring(i + 1));
                        }
                        ans = value1 * 2 + value2;
                    }
                    break;
                }
            }
        }
        cache.put(s, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.scoreOfParentheses("(()(()))");
        System.out.println(res);
    }
}
