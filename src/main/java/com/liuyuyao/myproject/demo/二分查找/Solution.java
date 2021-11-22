package com.liuyuyao.myproject.demo.二分查找;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author : mi
 * create at:  2021/5/31  下午5:53
 * @description:
 */
public class Solution {
    public int binarySearch(int[] nums, int target) {
        int low = 0, height = nums.length - 1;
        int mid = 0;
        while (low <= height) {
            mid = (low + height) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else{
                height = mid - 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1, 5, 8, 10};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n");
        for (int target = 1; target <= 16; target++) {
            int res = solution.binarySearch(array, target);
            System.out.println("当target=" + target + "查找到的位置是" + res);
        }
    }
}