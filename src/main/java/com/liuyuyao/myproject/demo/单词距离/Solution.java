package com.liuyuyao.myproject.demo.单词距离;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/27 下午8:23
 * @description：
 */
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int i = -1, j = -1;
        int ans = words.length;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)) {
                i = k;
            }
            if (words[k].equals(word2)) {
                j = k;
            }
            if (i >= 0 && j >= 0) {
                ans = Math.min(ans, Math.abs(i - j));
            }
        }
        return ans;
    }
}
