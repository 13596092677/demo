package com.liuyuyao.myproject.demo.最长连续序列;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/14 下午6:09
 * @description：
 */
public class Review {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet= new HashSet<>();
        Set<Integer> existingSet=new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            if (!hashSet.contains(num - 1) && !existingSet.contains(num)) {
                int next = num + 1;
                int len = 1;
                while (hashSet.contains(next)) {
                    next++;
                    len++;
                }
                existingSet.add(num);
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Review solution = new Review();
        int res = solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(res);
    }
}
