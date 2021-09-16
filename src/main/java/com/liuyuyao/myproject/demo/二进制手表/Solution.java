package com.liuyuyao.myproject.demo.二进制手表;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/16 3:28 下午
 * @description：
 */
public class Solution {
    List<String> left = new ArrayList<>();
    List<String> right = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<String> readBinaryWatch(int turnedOn) {
        for (int i = 0; i <= turnedOn; i++) {
            left = new ArrayList<>();
            right = new ArrayList<>();
            dfs(0, 0, i, 4,  "left");
            dfs(0, 0, turnedOn - i, 6, "right");

            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    ans.add(left.get(j) + ":" + right.get(k));
                }
            }
        }
        return ans;
    }

    void dfs(int status, int idx, int cnt, int limit, String type) {
        if ((type.equals("left") && status > 11) || (type.equals("right") && status > 59)) {
            return;
        }
        if (idx == limit) {
            if (cnt == 0) {
                if (type.equals("left")) {
                    left.add(String.valueOf(status));
                } else {
                    if (status == 0) {
                        right.add("00");
                    } else if (status < 10) {
                        right.add("0" + String.valueOf(status));
                    } else {
                        right.add(String.valueOf(status));
                    }
                }
            }
            return;
        }
        dfs(status, idx + 1, cnt, limit, type);
        dfs(status | (1 << idx), idx + 1, cnt - 1, limit, type);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.readBinaryWatch(4);
        System.out.println(res);
    }
}
