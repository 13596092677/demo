package com.liuyuyao.myproject.demo.最长公共前缀;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/10 上午9:22
 * @description：
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            len = Math.min(len, str.length());
        }
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.append(strs[0].charAt(i));
            } else{
                break;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(res);
    }
}
