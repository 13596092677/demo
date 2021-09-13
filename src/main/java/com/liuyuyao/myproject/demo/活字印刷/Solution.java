package com.liuyuyao.myproject.demo.活字印刷;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/11 4:16 下午
 * @description：
 */
public class Solution {
    int ans;
    char[] chars;
    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        chars = tiles.toCharArray();
        Arrays.sort(chars);
        dfs(visited, 0);
        return ans;
    }

    void dfs(boolean[] visited, int idx) {
        if (idx == chars.length) {
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] || (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])) {
                continue;
            }
            ans++;
            visited[i] = true;
            dfs(visited, idx + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numTilePossibilities("AAABBC");
        System.out.println(res);
    }
}
