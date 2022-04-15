package com.liuyuyao.myproject.demo.判断子序列;

import javax.jws.soap.SOAPBinding;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/15 下午4:10
 * @description：
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        for (char ch : t.toCharArray()) {
            if (idx < s.length() && ch == s.charAt(idx)) {
                idx++;
            }
        }
        return idx == s.length() ? true : false;
    }
}
