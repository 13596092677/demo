package com.liuyuyao.myproject.demo.子数组最大平均数I;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/26 下午3:32
 * @description：
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double res = solution.findMaxAverage(new int[]{1, 2, 3, 4, 5, 6}, 4);
        System.out.println(res);
    }
}
