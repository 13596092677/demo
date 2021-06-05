package com.liuyuyao.myproject.demo.柱状图中最大的矩形;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author : mi
 *
 * @description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        // 定义单调栈(递增)
        Stack<Integer> stack = new Stack<>();
        // 设置左边界和右边界
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        // 右边界默认设置为length
        Arrays.fill(right, heights.length);
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            // 当出栈时，设置出栈元素右边界为i,右边界的元素高度heights[item]都小于等于heights[i]
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                Integer top = stack.pop();
                right[top] = i;
            }
            // 当入栈时，设置入栈元素左边界为之前栈顶元素，左边界的元素高度heights[item]都小于heights[i]
            int top = stack.peek();
            left[i] = top;
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
        System.out.println(res);
    }
}
