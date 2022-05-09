package com.liuyuyao.myproject.demo.最小基因变化;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/7 上午10:09
 * @description：
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int[] masks = new int[bank.length + 1];
        int beginMask = convertMask(start);
        int endMask = convertMask(end);
        boolean contains = false;
        int idx = 0;
        for (int i = 0; i < bank.length; i++) {
            masks[i] = convertMask(bank[i]);
        }
        for (int i = 0; i < bank.length; i++) {
            if (masks[i] == endMask) {
                idx = i;
                contains = true;
            }
        }
        if (!contains) {
            return -1;
        }
        masks[bank.length] = beginMask;
        boolean[][] link = new boolean[bank.length + 1][bank.length + 1];
        for (int i = 0; i < bank.length + 1; i++) {
            for (int j = i + 1; j < bank.length + 1; j++) {
                link[i][j] = check(masks[i], masks[j]) ? true : false;
                link[j][i] = check(masks[i], masks[j]) ? true : false;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[bank.length + 1];
        Arrays.fill(dist, -1);
        dist[bank.length] = 0;
        boolean[] visited = new boolean[bank.length + 1];
        queue.add(bank.length);
        visited[bank.length] = true;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int i = 0; i < link[top].length; i++) {
                if (link[top][i] == true && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    dist[i] = dist[top] + 1;
                }
            }
        }
        return dist[idx];
    }

    boolean check(int mask1, int mask2) {
        int res = mask1 ^ mask2;
        if (Integer.bitCount(res) == 0) {
            return false;
        }
        if (Integer.bitCount(res) == 1) {
            return true;
        }
        for (int i = 0; i < 32; i++) {
            res >>= 1;
            if ((res & 1) == 1) {
                if ((res >> 1) == 1) {
                    return true;
                } else{
                    return false;
                }
            }
        }
        return false;
    }

    int convertMask(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            int op = 0;
            switch (s.charAt(i)) {
                case 'A':
                    op = 0;
                    break;
                case 'C':
                    op = 1;
                    break;
                case 'G':
                    op = 2;
                    break;
                case 'T':
                    op = 3;
                    break;
            }
            mask |= op << 2 * i;
        }
        return mask;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"});
        System.out.println(res);
    }
}
