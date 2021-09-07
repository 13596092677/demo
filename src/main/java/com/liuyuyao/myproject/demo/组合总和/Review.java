package com.liuyuyao.myproject.demo.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/6 4:33 下午
 * @description：
 */
public class Review {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List[] resDp = new List[target + 1];
        for (int i = 0; i <= target; i++) {
            resDp[i] = new ArrayList<ArrayList<Integer>>();
        }
        resDp[0].add(new ArrayList<Integer>());
        for (int i = 0; i < candidates.length; i++) {
            for (int j = candidates[i]; j <= target; j++) {
                for (int k = 0; k < resDp[j - candidates[i]].size(); k++) {
                    List<Integer> item = (List<Integer>) resDp[j - candidates[i]].get(k);
                    ArrayList<Integer> copyList = new ArrayList<>(item);
                    copyList.add(candidates[i]);
                    resDp[j].add(copyList);
                }
            }
        }
        return resDp[target];
    }
    public static void main(String[] args) {
        Review review = new Review();
        List<List<Integer>> res = review.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res);
    }
}
