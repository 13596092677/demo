package com.liuyuyao.myproject.demo.环绕字符串中唯一的子字符串;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/25 上午10:40
 * @description：
 */
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int ans = 1;
        int[] dp = new int[26];
        dp[p.charAt(0) - 'a'] = 1;
        int cnt = 1;
        for (int i = 1; i < p.length(); i++) {
            int cur = p.charAt(i) - 'a';
            int diff = p.charAt(i) - p.charAt(i - 1);
            if (diff == 1 || diff == -25) {
                cnt += 1;
            } else{
                cnt = 1;
            }
            ans += Math.max(cnt - dp[cur], 0);
            dp[cur] = Math.max(dp[cur], cnt);
        }
        return ans;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findSubstringInWraproundString("cdefghefghijklmnopqrstuvwxmnijklm");
        System.out.println(res);
    }
}
