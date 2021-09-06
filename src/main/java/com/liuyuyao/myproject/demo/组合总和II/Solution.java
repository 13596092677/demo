package com.liuyuyao.myproject.demo.组合总和II;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/6/14 10:57 下午
 * @description：
 */
public class Solution {
    public int inc() {
        int x;
        try {
            x = 1;
            System.out.println(x);
        } catch (Exception e) {
            x = 2;
        } finally {
            x = 3;
            System.out.println(x);
            return x;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List[] dp = new List[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<ArrayList<Integer>>();
        }
        dp[0].add(new ArrayList<>());
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - candidates[i] >= 0) {
                    for (Object list : dp[j - candidates[i]]) {
                        ArrayList<Integer> copy = new ArrayList<Integer>((ArrayList) list);
                        copy.add(candidates[i]);
                        dp[j].add(copy);
                    }
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<List<Integer>> res = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        System.out.println(res);
        int ans = solution.inc();
        System.out.println(ans);
    }
}
