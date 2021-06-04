package com.liuyuyao.myproject.demo.最接近的三数之和;

import java.util.Arrays;

/**
 * @author : mi
 * create at:  2021/6/2  下午5:20
 * @description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 1000000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int left = i + 1, right = nums.length - 1; left < right; ) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return res;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.threeSumClosest(new int[]{-3, 0, 1, 2}, 1);
        System.out.println(res);
    }
}