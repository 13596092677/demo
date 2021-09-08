package com.liuyuyao.myproject.demo.复原IP地址;

import jdk.nashorn.internal.parser.Scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/8 3:37 下午
 * @description：
 */
public class Solution {
    StringBuffer address = new StringBuffer();
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 4);
        return ans;
    }

    void dfs(String s, int idx, int cnt) {
        if (cnt == 0) {
            if(idx == s.length()) {
                ans.add(address.toString().substring(0, address.length() - 1));
            }
            return;
        }
        // 加入剪枝策略，如果当前剩余子串长度大于3*cnt或者小于cnt，则直接返回
        // 剩余子串长度 s.length()-idx
        // 最大值 255, 长度为3*cnt
        // 最小值 0， 长度为cnt
        if (s.length() - idx > 3 * cnt || s.length() - idx < cnt) {
            return;
        }
        StringBuffer temp = new StringBuffer();
        for (int i = idx; i < s.length(); i++) {
            temp.append(s.charAt(i));
            if (isValidNumeric(temp.toString())) {
                address.append(temp + ".");
                dfs(s, idx + temp.length(), cnt - 1);
                address.delete(address.length() - temp.length() - 1, address.length());
            } else{
                return;
            }
        }
    }

    boolean isValidNumeric(String s) {
        // 如果前导'0'且该数字不为'0'，则直接返回false
        if (s.length() != 1 && s.charAt(0)=='0') {
            return false;
        }
        if (Integer.valueOf(s).intValue() >= 0 && Integer.valueOf(s).intValue() <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.restoreIpAddresses("101023");
        System.out.println(res);
    }
}
