package com.liuyuyao.myproject.demo.一次编辑;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/13 上午10:42
 * @description：
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        if(first.equals(second)){
            return true;
        }
        int len1 = first.length();
        int len2 = second.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                // 替换即可
                if (first.substring(i + 1, len1).equals(second.substring(i + 1, len2))) {
                    return true;
                }
                // 插入即可
                if (first.substring(i + 1, len1).equals(second.substring(i, len2)) ) {
                    return true;
                }
                // 删除即可
                if (first.substring(i, len1).equals(second.substring(i + 1, len2))) {
                    return true;
                }
                return false;
            }
        }
        return Math.abs(len1 - len2) == 1 ? true : false;
    }
}
