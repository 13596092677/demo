package com.liuyuyao.myproject.demo.至少有K个重复字符的最长子串;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/23 10:14 下午
 * @description：
 */
public class Solution {
    // 分治法
    // 对于字符串 ss，如果存在某个字符 \textit{ch}ch，它的出现次数大于 00 且小于 kk，则任何包含 \textit{ch}ch 的子串都不可能满足要求。也就是说，我们将字符串按照 \textit{ch}ch 切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。因此，可以考虑分治的方式求解本题。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/zhi-shao-you-kge-zhong-fu-zi-fu-de-zui-c-o6ww/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int longestSubstring(String s, int k) {
        return dfs(s, k, 0, s.length());
    }

    int dfs(String s, int k, int start, int end) {
        int[] cnt = new int[26];
        for (int i = start; i < end; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) ('a' + i);
                break;
            }
        }
        if (split == 0) {
            return end - start;
        }
        int i = start;
        int ans = 0;
        while (i < end) {
            while (i < end && s.charAt(i) == split) {
                i++;
            }
            int left = i;
            if (i >= end) {
                break;
            }
            while (i < end && s.charAt(i) != split) {
                i++;
            }
            int res = dfs(s, k, left, i);
            ans = Math.max(ans, res);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestSubstring(
                "abcdedghijklmnopqrstuvwxyz", 2);
        System.out.println(res);
    }
}
