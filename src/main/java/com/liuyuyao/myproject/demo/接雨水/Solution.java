package com.liuyuyao.myproject.demo.接雨水;

import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2021/6/5 10:47 下午
 * @description：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 */
public class Solution {
    public int trap(int[] height) {
        int res = 0;
        // 定义单调栈(非严格递减或者严格递减都可以)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int secTop = stack.peek();
                res += (i - secTop - 1) * (Math.min(height[i], height[secTop]) - height[top]);
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.trap(new int[]{4,2,0,3,2,5});
        System.out.println(res);
    }
}
