package com.liuyuyao.myproject.demo.乘积最大子数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/13 下午5:41
 * @description：
 */
public class Review {
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = max[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(Math.min(nums[i] * min[i-1], nums[i] * max[i-1]), nums[i]);
            max[i] = Math.max(Math.max(nums[i] * max[i-1], nums[i] * min[i-1]), nums[i]);
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Review review = new Review();
        int res = review.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(res);
    }
}
