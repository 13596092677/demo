package com.liuyuyao.myproject.demo.组合总和III;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/6 下午10:53
 * @description：
 */
public class Review1 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, 0, n);
        return ans;
    }

    void dfs(int idx, int k, int cnt, int target) {
        if (target == 0 && k == cnt) {
            ans.add(new ArrayList(list));
            return;
        }
        if (idx == 10) {
            return;
        }
        dfs(idx + 1, k, cnt, target);
        if (idx <= target) {
            list.add(idx);
            dfs(idx + 1, k, cnt + 1, target - idx);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Review1 review1 = new Review1();
        List<List<Integer>> res = review1.combinationSum3(2, 4);
        System.out.println(res);
    }
}
