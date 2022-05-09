package com.liuyuyao.myproject.demo.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/6 下午4:42
 * @description：
 */
public class Review1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] dp = new int[target + 1];
        List<List<Integer>>[] resList = new ArrayList[target + 1];
        for (int i = 0; i < resList.length; i++) {
            resList[i] = new ArrayList<>();
        }
        resList[0].add(new ArrayList<>());
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= candidates[i]) {
                    dp[j] += dp[j - candidates[i]];
                    for (List<Integer> list : resList[j - candidates[i]]) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(candidates[i]);
                        resList[j].add(newList);
                    }
                }
            }
        }
        return resList[target];
    }

    public static void main(String[] args) {
        Review1 solution = new Review1();
        List<List<Integer>> ans = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(ans);

    }
}
