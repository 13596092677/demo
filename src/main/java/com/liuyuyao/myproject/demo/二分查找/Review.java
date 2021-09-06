package com.liuyuyao.myproject.demo.二分查找;

import javax.jws.soap.SOAPBinding;

/**
 * @author ：lyy
 * @date ：Created in 2021/7/26 10:49 上午
 * @description：
 */
public class Review {
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        while (low < height) {
            int mid = (low + height) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else{
                height = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Review review = new Review();
        int res = review.binarySearch(new int[]{1,2}, 2);
        System.out.println(res);
    }
}
