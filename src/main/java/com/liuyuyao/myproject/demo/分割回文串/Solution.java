package com.liuyuyao.myproject.demo.分割回文串;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/8 9:06 下午
 * @description：
 */
public class Solution {
    List<String> temp = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<List<String>>> hashMap = new HashMap<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return ans;
    }

    List<List<String>> dfs(String s, int idx) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(temp));
            return new ArrayList<List<String>>(){
                {
                    add(new ArrayList<>());
                }
            };
        }
        StringBuffer sb = new StringBuffer();
        List<List<String>> res = new ArrayList<>();
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isValidPalindrome(sb.toString())) {
                temp.add(sb.toString());
                List<List<String>> nxt;
                if (i + 1 < s.length() && hashMap.containsKey(s.substring(i + 1))) {
                    List<List<String>> lists = hashMap.get(s.substring(i + 1));
                    for (int j = 0; j < lists.size(); j++) {
                        temp.addAll(lists.get(j));
                        nxt = dfs(s, s.length());
                        for (int k = 0; k < lists.get(j).size(); k++) {
                            temp.remove(temp.size() - 1);
                        }
                        List<String> str = new ArrayList<>();
                        str.add(sb.toString());
                        str.addAll(lists.get(j));
                        res.add(str);
                    }
                    temp.remove(temp.size() - 1);
                } else {
                    nxt = dfs(s, idx + sb.length());
                    temp.remove(temp.size() - 1);
                    for (int j = 0; j < nxt.size(); j++) {
                        List<String> str = new ArrayList<>();
                        str.add(sb.toString());
                        str.addAll(nxt.get(j));
                        res.add(str);
                    }
                }
            }
        }
        if (!hashMap.containsKey(s.substring(idx))) {
            hashMap.put(s.substring(idx), res);
        }
        return res;
    }

    boolean isValidPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.partition("abbab");
        System.out.println(res);
    }
}
