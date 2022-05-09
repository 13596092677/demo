package com.liuyuyao.myproject.demo.最佳观光组合;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/7 下午3:47
 * @description：
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int mx = values[0] + 0;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, mx + values[i] - i);
            mx = Math.max(mx, values[i] + i);
        }
        return ans;
    }
}
