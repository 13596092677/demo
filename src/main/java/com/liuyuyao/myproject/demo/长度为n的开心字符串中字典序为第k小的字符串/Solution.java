package com.liuyuyao.myproject.demo.长度为n的开心字符串中字典序为第k小的字符串;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/13 3:59 下午
 * @description：
 */
public class Solution {
    StringBuffer happyString = new StringBuffer();
    String ans = "";
    int cnt;
    public String getHappyString(int n, int k) {
        dfs(n, k, 0, ' ');
        return ans;
    }


    void dfs(int n, int k, int idx, char last) {
        if (idx == n) {
            cnt++;
            if (cnt == k) {
                ans = happyString.toString();
            }
            return;
        }
        for (char i = 'a'; i <= 'c'; i++) {
            if (i == last) {
                continue;
            }
            happyString.append(i);
            dfs(n, k, idx + 1, i);
            happyString.deleteCharAt(happyString.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.getHappyString(3, 9);
        System.out.println(res);
    }
}
