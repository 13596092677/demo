package com.liuyuyao.myproject.demo.合并区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/13 上午11:51
 * @description：
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        // 数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        boolean[] selected = new boolean[intervals.length];
        Arrays.fill(selected, true);
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                selected[i - 1] = false;
                cnt++;
            }
        }
        int[][] ans = new int[intervals.length - cnt][2];
        int idx = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                ans[idx][0] = intervals[i][0];
                ans[idx][1] = intervals[i][1];
                idx++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.merge(new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}});
        System.out.println(res);
    }
}
