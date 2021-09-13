package com.liuyuyao.myproject.demo.串联字符串的最大长度;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/12 10:31 下午
 * @description：
 */
public class Solution {
    int ans;
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            int mask = 0;
            for (int j = 0; j < s.length(); j++) {
                int ch = s.charAt(j) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
            }
            masks.add(mask);
        }
        dfs(masks, 0, 0);
        return ans;
    }

    void dfs(List<Integer> masks,  int idx, int status) {
        if (idx == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(status));
            return;
        }
        // 如果与当前状态对应序列没有共同的字符，则&结果为0
        if ((masks.get(idx) & status) == 0) {
            dfs(masks, idx + 1, status | masks.get(idx));
        }
        dfs(masks, idx + 1, status);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxLength(Arrays.asList("yy", "bkhwmpbiisbldzknpm"));
        System.out.println(res);
    }
}
