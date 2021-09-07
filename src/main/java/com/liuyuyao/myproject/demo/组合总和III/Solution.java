package com.liuyuyao.myproject.demo.组合总和III;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/7 9:46 上午
 * @description：
 */
public class Solution {
    List<Integer> combine = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, 9, combine, ans, n);
        return ans;
    }

    void dfs(int cnt, int idx, List<Integer> combine, List<List<Integer>> ans, int target) {
        if (target == 0 && cnt == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        if (idx == 0) {
            return;
        }
        dfs(cnt, idx - 1, combine, ans, target);
        if (target >= idx) {
            combine.add(idx);
            dfs(cnt - 1, idx - 1, combine, ans, target - idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum3(3, 9);
        System.out.println(res);
    }
}
