package com.liuyuyao.myproject.demo.猜字谜;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/26 5:14 下午
 * @description：
 */
public class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] hashWords = new int[words.length];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                hashWords[i] |= 1 << ch - 'a';
            }
            hashMap.put(hashWords[i], hashMap.getOrDefault(hashWords[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            int total = 0;
            for (int j = 0; j < 1 << 6; j++) {
                int mask = 0;
                for (int k = 0; k < 6; k++) {
                    if ((j >> k & 1) == 1) {
                        mask |= 1 << puzzles[i].charAt(k + 1) - 'a';
                    }
                }
                mask |= 1 << puzzles[i].charAt(0) - 'a';
                total += hashMap.getOrDefault(mask, 0);
            }
            ans.add(total);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findNumOfValidWords(new String[]{"apple","pleas","please"}, new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"});
        System.out.println(res);
    }
}