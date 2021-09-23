package com.liuyuyao.myproject.demo.字符串的好分割数目;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/23 9:36 上午
 * @description：
 */
public class Solution {
    public int numSplits(String s) {
        // 用一个切点来分割左右子串
        int split = 1;
        // 定义左子串的掩码和右子串的掩码。
        // 其实是一个26位的二进制数，分别对应26位字母，每一位代表当前子串是否包含了对应字母
        int leftMask = 0, rightMask = 0;
        // 结果计数器
        int res = 0;
        // 维护一个右子串的字母计数器，当计数器归0时，将对应掩码位设置为0
        // (也可以通过hashMap维护。但是因为题意只有26个字母，所以选择数组。并且测试了一下用数组维护时间效率更高)
        // (并不需要维护左子串的字母计数器，因为左子串是不断增加的，所以只需要第一次遇到字母置为1即可)
        int[] rightCount = new int[26];
        // 先假设为左右两个子串，切点设置为1，遍历右子串所有字母得到对应掩码与字母计数器
        for (int i = 0; i < s.length(); i++) {
            rightCount[s.charAt(i) - 'a']++;
            if ((rightMask >> s.charAt(i) - 'a' & 1) == 0) {
                rightMask |= 1 << s.charAt(i) - 'a';
            }
        }
        // 切点逐步右移，动态更新左右子串对应掩码，直到整个字符串
        // 左子串加入待选字母，右子串删除待选字母
        while (split <= s.length()) {
            // 左子串是否已包括待选字母
            if ((leftMask >> s.charAt(split - 1) - 'a' & 1) == 0) {
                // 没有待选字母则对应位 置为1
                leftMask |= 1 << s.charAt(split - 1) - 'a';
            }
            // 右子串是否删除待选字母后没有对应字母
            if (--rightCount[s.charAt(split - 1)-'a'] == 0) {
                // 没有待选字母则对应位 置为0
                rightMask ^= 1 << s.charAt(split - 1) - 'a';
            }
            // 判断左右子串不相同字母数是否相同
            boolean check = check(leftMask, rightMask);
            if (check) {
                // 结果+1
                res++;
            }
            // 切点右移
            split++;
        }
        return res;
    }

    boolean check(int leftMask, int rightMask) {
        return Integer.bitCount(leftMask) == Integer.bitCount(rightMask);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSplits("aacaba");
        System.out.println(res);
    }
}
