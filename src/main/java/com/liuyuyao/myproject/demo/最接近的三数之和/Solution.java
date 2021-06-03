package com.liuyuyao.myproject.demo.最接近的三数之和;

import java.util.Arrays;
class Solution {
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
                    int left0 = left + 1;
                    // 移动到下一个不相等的元素
                    while (left0 < right && nums[left0] == nums[left]) {
                        ++left0;
                    }
                    left = left0;
                    // if分支代码块是优化后代码，和注释内代码等效
                    /*left++*/
                } else if (sum > target) {
                    int right0 = right - 1;
                    // 移动到下一个不相等的元素
                    while (left < right0 && nums[right0] == nums[right]) {
                        --right0;
                    }
                    right = right0;
                    // if分支代码块是优化后代码，和注释内代码等效
                    /*right--*/
                }else {

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
        int res = solution.threeSumClosest(new int[]{-1, 0, 1, 1, 55}, 3);
        System.out.println(res);
    }
}
