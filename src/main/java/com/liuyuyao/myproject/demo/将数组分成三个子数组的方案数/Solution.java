package com.liuyuyao.myproject.demo.将数组分成三个子数组的方案数;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/6/4  下午2:53
 * @description: 我们称一个分割整数数组的方案是 好的 ，当它满足：
 *
 * 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
 * left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
 * 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
 *
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int waysToSplit(int[] nums) {
        int res = 0;
        int mod = 100000000 + 7;
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length - 2; i++) {
            sum1 += nums[i];
            if (sum1 < sum - sum1) {
                for (int j = nums.length - 1; i + 2 <= j; j--) {
                    sum3 += nums[j];
                    sum2 = sum - sum1 - sum3;
                    if (sum1 <= sum2 && sum2 <= sum3) {
                        res = res % mod + 1;
                    }
                }
                sum3 = 0;
            } else {
                return res;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.waysToSplit(new int[]{3,2,1});
        System.out.println(res);
    }
}