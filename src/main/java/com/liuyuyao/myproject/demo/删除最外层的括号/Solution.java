package com.liuyuyao.myproject.demo.删除最外层的括号;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/28 上午7:49
 * @description：
 */
public class Solution {
    public String removeOuterParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        int left = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                if (stack.isEmpty()) {
                    left = i;
                }
                stack.push(i);
            } else{
                stack.pop();
                if (stack.isEmpty()) {
                    right = i;
                    ans.append(s.substring(left + 1, right));
                }
            }
        }
        return ans.toString();
    }
}
