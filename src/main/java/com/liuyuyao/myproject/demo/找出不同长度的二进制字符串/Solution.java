package com.liuyuyao.myproject.demo.找出不同长度的二进制字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/14 10:50 上午
 * @description：
 */
public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> a = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!a.contains(nums[i])) {
                a.add(nums[i]);
            }
        }
        for (int i = 0; i < 1 << nums.length; i++) {
            String src = Integer.toBinaryString(i);
            int bitCount = getBitCount(i);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < nums.length - bitCount; j++) {
                sb.append('0');
            }
            sb.append(src);
            if (!a.contains(sb.toString())) {
                return sb.toString();
            }
        }
        return new String();
    }

    int getBitCount(int n) {
        int cnt = 1;
        while (true) {
            if (n < (int) Math.pow(2, cnt)) {
                return cnt;
            }
            cnt++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.findDifferentBinaryString(new String[]{"00", "01"});
        System.out.println(res);
    }
}
