package com.liuyuyao.myproject.demo.将字符串拆分成连续的递减值;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/17 10:25 上午
 * @description：
 */
public class Solution {
    List<String> split = new ArrayList<>();
    public boolean splitString(String s) {
        return dfs(s, 0, -1);
    }

    boolean dfs(String s, int idx, long last) {
        if (idx == s.length() && split.size() >= 2) {
            System.out.println(split);
            return true;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (!isValid(sb.toString(), last)) {
                continue;
            }
            split.add(sb.toString());
            boolean res = dfs(s, idx + sb.length(), new BigInteger(sb.toString()).longValue());
            split.remove(split.size() - 1);
            if (res) {
                return true;
            }
        }
        return false;
    }

    boolean isValid(String s, long last) {
        if (split.size() == 0) {
            return true;
        }
        if (new BigInteger(s).longValue() - last == -1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.splitString("3202872236");
        System.out.println(res);
    }
}
