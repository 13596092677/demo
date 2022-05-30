package com.liuyuyao.myproject.demo.寻找右区间;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/20 上午9:24
 * @description：
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] nums = new int[intervals.length];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            nums[i] = intervals[i][0];
            hashMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int left = 0;
            int right = nums.length - 1;
            int res = -1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] == end) {
                    res = mid;
                    break;
                } else if (nums[mid] > end) {
                    res = mid;
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
            ans[i] = res == -1 ? -1 : hashMap.get(nums[res]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}});
        System.out.println(Arrays.asList(res));
        Arrays.sort(res);
    }
}
