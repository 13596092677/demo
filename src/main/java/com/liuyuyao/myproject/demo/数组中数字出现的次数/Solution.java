package com.liuyuyao.myproject.demo.数组中数字出现的次数;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/8 上午9:56
 * @description：
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int div = 0;
        for (int i = 0; i <= Integer.highestOneBit(ret); i++) {
            if ((ret >> i & 1) == 1) {
                div = i;
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num >> div & 1) == 1) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
