package com.liuyuyao.myproject.demo.最长有效括号;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/28 上午7:59
 * @description：
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else{
                if (stack.isEmpty() || s.charAt(stack.peek()) == ')') {
                    stack.push(i);
                } else {
                    stack.pop();
                    int top = -1;
                    if (!stack.isEmpty()) {
                        top = stack.peek();
                    }
                    ans = Math.max(ans, i - top);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestValidParentheses(")()())");
        System.out.println(res);
    }
}
