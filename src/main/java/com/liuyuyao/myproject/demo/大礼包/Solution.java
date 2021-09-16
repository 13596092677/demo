package com.liuyuyao.myproject.demo.大礼包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/16 10:31 上午
 * @description：
 */
public class Solution {
    int ans = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        dfs(price, special, needs, 0);
        return ans;
    }

    void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int budget) {
        if (budget > ans) {
            return;
        }
        if (meetNeed(needs)) {
            ans = Math.min(ans, budget);
            return;
        }
        for (int i = 0; i < special.size(); i++) {
            if (!isValid(special.get(i), needs)) {
                continue;
            }
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) - special.get(i).get(j));
            }
            dfs(price, special, needs, budget + special.get(i).get(price.size()));
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) + special.get(i).get(j));
            }
        }
        List<Integer> copyNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            budget += price.get(i) * needs.get(i);
        }
        dfs(price, special, copyNeeds, budget);
    }

    boolean isValid(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i)) {
                return false;
            }
        }
        return true;
    }

    boolean meetNeed(List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        int res = solution.shoppingOffers(Arrays.asList(2, 5), list, Arrays.asList(3, 2));
        System.out.println(res);
    }
}
