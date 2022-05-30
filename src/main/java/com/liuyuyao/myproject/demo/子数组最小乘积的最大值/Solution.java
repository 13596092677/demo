package com.liuyuyao.myproject.demo.子数组最小乘积的最大值;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/26 下午10:44
 * @description：
 */
public class Solution {
    public int maxSumMinProduct(int[] nums) {
        long[] sum = new long[nums.length];
        int[] leftBound = new int[nums.length];
        int[] rightBound = new int[nums.length];
        long leftSum = 0;
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(rightBound, nums.length);
        int MOD = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            sum[i] = leftSum;
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                int pop = stack.pop();
                rightBound[pop] = i;
            }
            leftBound[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long temp = 0;
            if (leftBound[i] == -1) {
                temp = 0;
            } else{
                temp = sum[leftBound[i]];
            }
            ans = Math.max(ans, nums[i] * (sum[rightBound[i] - 1] - temp));
        }
        return (int) (ans % MOD);
    }
    public int maxSumMinProduct1(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        // 对于每一个i 找到右侧连续的不小于它的元素，记录最后一个连续的，不小于它的元素对应下标
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                right[stack.pop()] = i - 1;
            }
            stack.push(i);//存放的是下标
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = len - 1;
        }

        // 对于每一个i 找到左侧连续的不小于它的元素，记录最后一个连续的，不小于它的元素对应下标
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left[stack.pop()] = i + 1;
            }
            stack.push(i);//存放的是下标
        }
        while (!stack.isEmpty()) {
            left[stack.pop()] = 0;
        }

        //前缀和,用long来存放，防止相加时溢出
        long[] dp = new long[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        long result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, nums[i] * (dp[right[i]] - dp[left[i]] + nums[left[i]]));
        }//right[i]为右坐标 left[i]为左坐标，从left[i]到right[i]所有元素的和应该是dp[right[i]]-dp[left[i]]+nums[left[i]]
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxSumMinProduct(new int[]{8, 2, 3, 4, 10, 3, 2, 8});
        System.out.println(res);
    }
}
