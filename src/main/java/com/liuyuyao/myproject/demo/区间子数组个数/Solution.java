package com.liuyuyao.myproject.demo.区间子数组个数;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/24 上午10:47
 * @description：
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        Arrays.fill(rightMax, nums.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                int pop = stack.pop();
                rightMax[pop] = i;
            }
            leftMax[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = (i - leftMax[i]) * (rightMax[i] - i);
            if (nums[i] >= left && nums[i] <= right) {
                ans += cnt;
            }
        }
        return ans;
    }

    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    int count(int[] nums, int bound) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= bound) {
                cnt = cnt + 1;
            } else{
                cnt = 0;
            }
            res += cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSubarrayBoundedMax1(new int[]{2, 1, 4, 3}, 2, 3);
        System.out.println(res);
    }
}
