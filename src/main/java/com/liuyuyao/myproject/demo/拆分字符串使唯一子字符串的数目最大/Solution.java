package com.liuyuyao.myproject.demo.拆分字符串使唯一子字符串的数目最大;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/13 5:04 下午
 * @description：
 */
public class Solution {
    List<String> split = new ArrayList<>();
    Set<String> hashSet = new HashSet<>();
    int ans;
    public int maxUniqueSplit(String s) {
        dfs(s, 0);
        return ans;
    }

    void dfs(String s, int idx) {
        if (idx == s.length()) {
            ans = Math.max(ans,split.size());
        }
        StringBuffer sb = new StringBuffer();
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (hashSet.contains(sb.toString())) {
                continue;
            }
            hashSet.add(sb.toString());
            split.add(sb.toString());
            dfs(s, idx + sb.length());
            hashSet.remove(sb.toString());
            split.remove(split.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxUniqueSplit("wwwzfvedwfvhsww");
        System.out.println(res);
    }
}
