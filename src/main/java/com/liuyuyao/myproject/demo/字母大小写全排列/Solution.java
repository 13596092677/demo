package com.liuyuyao.myproject.demo.字母大小写全排列;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/10 10:46 上午
 * @description：
 */
public class Solution {
    StringBuffer permutation = new StringBuffer();
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        dfs(s, 0);
        return ans;
    }

    void dfs(String s, int idx) {
        if (idx == s.length()) {
            ans.add(new String(permutation.toString()));
            return;
        }
        permutation.append(s.charAt(idx));
        dfs(s, idx + 1);
        permutation.deleteCharAt(permutation.length() - 1);
        if (Character.isUpperCase(s.charAt(idx))) {
            permutation.append(Character.toLowerCase(s.charAt(idx)));
            dfs(s, idx + 1);
            permutation.deleteCharAt(permutation.length() - 1);
        }
        if (Character.isLowerCase(s.charAt(idx))) {
            permutation.append(Character.toUpperCase(s.charAt(idx)));
            dfs(s, idx + 1);
            permutation.deleteCharAt(permutation.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.letterCasePermutation("a1b2");
        System.out.println(res);
    }
}
