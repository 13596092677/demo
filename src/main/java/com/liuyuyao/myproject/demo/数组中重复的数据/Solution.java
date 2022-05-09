package com.liuyuyao.myproject.demo.数组中重复的数据;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/8 上午10:26
 * @description：
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(res);

    }
}
