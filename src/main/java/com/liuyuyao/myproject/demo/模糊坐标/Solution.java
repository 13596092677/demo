package com.liuyuyao.myproject.demo.模糊坐标;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/10 11:51 上午
 * @description：
 */
public class Solution {
    StringBuffer coordinate = new StringBuffer();
    List<String> ans = new ArrayList<>();
    public List<String> ambiguousCoordinates(String s) {
        dfs(s.substring(0, s.length() - 1).substring(1, s.length() - 1), 0, 2);
        return ans;
    }

    void dfs(String s, int idx, int cnt) {
        if (cnt == 0) {
            if (idx == s.length()) {
                ans.add("(" + coordinate.toString().substring(0, coordinate.length() - 1) + ")");
            }
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            List<String> validStringList = make(sb.toString(), 0, sb.length());
            if (!CollectionUtils.isEmpty(validStringList)) {
                for (int j = 0; j < validStringList.size(); j++) {
                    coordinate.append(validStringList.get(j) + ",");
                    dfs(s, i + 1, cnt - 1);
                    coordinate.delete(coordinate.length() - validStringList.get(j).length() - 1, coordinate.length());
                }
            }
        }
    }

    public List<String> make(String S, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j-i; ++d) {
            String left = S.substring(i, i+d);
            String right = S.substring(i+d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j-i ? "." : "") + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.ambiguousCoordinates("(123)");
        System.out.println(res);
        solution.make("123", 0, 3);
    }
}
