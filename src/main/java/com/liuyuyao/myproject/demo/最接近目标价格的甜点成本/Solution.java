package com.liuyuyao.myproject.demo.最接近目标价格的甜点成本;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/16 5:20 下午
 * @description：
 */
public class Solution {
    int ans;
    int min = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] expandToppingCosts = new int[2 * toppingCosts.length];
        for (int i = 0; i < toppingCosts.length; i++) {
            expandToppingCosts[2 * i] = toppingCosts[i];
            expandToppingCosts[2 * i + 1] = toppingCosts[i];
        }
        dfs(baseCosts, expandToppingCosts, target, false, 0, 0);
        return ans;
    }

    void dfs(int[] baseCosts, int[] toppingCosts, int target, boolean chooseBase, int budget, int idx) {
        if (budget >= ans && Math.abs(budget - target) >= min) {
            return;
        }
        if (idx == baseCosts.length) {
            if (!chooseBase) {
                return;
            }
        }
        if (idx == baseCosts.length + toppingCosts.length) {
            if (chooseBase) {
                if (Math.abs(budget - target) < min) {
                    min = Math.abs(budget - target);
                    ans = budget;
                } else if (Math.abs(budget - target) == min) {
                    if (budget < ans) {
                        min = Math.abs(budget - target);
                        ans = budget;
                    }
                }
            }
            return;
        }
        if (idx < baseCosts.length) {
            if (!chooseBase) {
                chooseBase = true;
                dfs(baseCosts, toppingCosts, target, chooseBase, budget + baseCosts[idx], idx + 1);
                chooseBase = false;
            }
            dfs(baseCosts, toppingCosts, target, chooseBase, budget, idx + 1);
        } else if (idx >= baseCosts.length && idx < baseCosts.length + toppingCosts.length) {
            dfs(baseCosts, toppingCosts, target, chooseBase, budget + toppingCosts[idx - baseCosts.length], idx + 1);
            dfs(baseCosts, toppingCosts, target, chooseBase, budget, idx + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.closestCost(new int[]{3, 10}, new int[]{2, 5}, 9);
        System.out.println(res);
    }
}
