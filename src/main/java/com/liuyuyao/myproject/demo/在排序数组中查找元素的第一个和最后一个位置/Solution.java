package com.liuyuyao.myproject.demo.在排序数组中查找元素的第一个和最后一个位置;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/10 下午3:41
 * @description：
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else{
                right = mid - 1;
                first = mid;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else{
                left = mid + 1;
                last = mid;
            }
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(res);
    }
}
