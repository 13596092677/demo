package com.liuyuyao.myproject.demo.连续差相同的数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/11 3:47 下午
 * @description：
 */
public class Solution {
    StringBuffer sb = new StringBuffer();
    List<Integer> ans = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        dfs(n, k, 0);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    void dfs(int n, int k, int idx) {
        if (idx == n) {
            if(isValid(sb.toString())){
                ans.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            if (sb.length() != 0) {
                Character last = sb.charAt(sb.length() - 1);
                if (Math.abs(last - i) == k) {
                    sb.append(i);
                    dfs(n, k, idx + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else{
                sb.append(i);
                dfs(n, k, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    boolean isValid(String s) {
        if (s.startsWith("0")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.numsSameConsecDiff(2, 1);
        System.out.println(res);
    }
}
