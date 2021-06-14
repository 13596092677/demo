package com.liuyuyao.myproject.demo.数位成本和为目标值的最大数字;

import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/6/14 11:28 上午
 * @description：
 */
public class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < cost.length; j++) {
                int item = j + 1;
                if (i - cost[j] >= 0 && dp[i - cost[j]] != null) {
                    if (dp[i] == null) {
                        dp[i] = dp[i - cost[j]] + item;
                    } else {
                        dp[i] = compare(dp[i - cost[j]] + item, dp[i]);
                    }
                }
            }
        }
        return dp[target] != null ? dp[target] : "0";
    }

    String compare(String str1, String str2) {
        if( str1.length() != str2.length()){
            return str1.length() >= str2.length() ? str1 : str2;
        } else{
            for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    continue;
                } else{
                    return str1.charAt(i) >= str2.charAt(i) ? str1 : str2;
                }
            }
        }
        return str1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9);
        System.out.println(res);
    }
}
