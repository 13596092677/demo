package com.liuyuyao.myproject.demo.和大于等于target的最短子数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/21 下午3:57
 * @description：
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            boolean flag = true;
            while (true) {
                if (sum < target) {
                    flag = false;
                    break;
                }
                if (sum >= target && sum - nums[j] < target) {
                    break;
                }
                sum -= nums[j];
                j++;
            }
            if (flag) {
                ans = Math.min(ans, i - j + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(res);
    }
}
