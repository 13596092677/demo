package com.liuyuyao.myproject.demo.盛最多水的容器;

import java.util.Stack;

/**
 * @author : mi
 * create at:  2021/6/4  上午10:08
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i ) * height[i]);
                i++;
            } else{
                res = Math.max(res, (j - i ) * height[j]);
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxArea(new int[]{1, 2, 1});
        System.out.println(res);
    }
}