package com.liuyuyao.myproject.demo.两个回文子序列长度的最大乘积;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/22 10:06 上午
 * @description：
 */
public class Review {
    public int maxProduct(String s) {
        int mask = 1 << s.length();
        List<int[]> list = new ArrayList<>();
        char[] chs = s.toCharArray();
        for (int i = 1; i < mask; i++) {
            if (check(chs, i)) {
                list.add(new int[]{i, Integer.bitCount(i)});
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i)[0] & list.get(j)[0]) == 0) {
                    res = Math.max(res, list.get(i)[1] * list.get(j)[1]);
                }
            }
        }
        return res;
    }

    boolean check(char[] chs, int mask) {
        int i = 0, j = chs.length;
        while (i < j) {
            while (i < j && (mask >> i & 1) == 0) {
                i++;
            }
            while (i < j && (mask >> j & 1) == 0) {
                j--;
            }
            if (chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Review review = new Review();
        int res = review.maxProduct("bb");
        System.out.println(res);
    }
}
