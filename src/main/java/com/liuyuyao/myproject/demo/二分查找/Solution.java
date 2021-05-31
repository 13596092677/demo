package com.liuyuyao.myproject.demo.二分查找;

/**
 * @author : mi
 * create at:  2021/5/31  下午5:53
 * @description:
 */
public class Solution {
    public int binarySearch(int[] nums, int target) {
        int low = 0, height = nums.length - 1;
        while (low <= height) {
            int mid = (low + height) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else{
                height = mid - 1;
            }
        }
        return -1;
    }
}