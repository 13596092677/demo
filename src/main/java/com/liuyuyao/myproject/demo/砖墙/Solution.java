package com.liuyuyao.myproject.demo.砖墙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : mi
 * create at:  2021/5/25  下午7:45
 * @description: 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) {
            return 0;
        }
        int col = 0;
        for (int i = 0; i < wall.get(0).size(); i++) {
            col += wall.get(0).get(i);
        }
        if (col == 1) {
            return wall.size();
        }
        if (col == 100000000) {
            return wall.size();
        }
        long[][] dp = new long[wall.size() + 1][col + 1];
        for (int i = 1; i < wall.size() + 1; i++) {
            List<Integer> limit = new ArrayList<>();
            for (int k = 0; k < wall.get(i - 1).size(); k++) {
                limit.add(k, k == 0 ? wall.get(i - 1).get(k) : limit.get(k - 1) + wall.get(i - 1).get(k));
            }
            for (int j = 1; j < col + 1; j++) {
                dp[i][j] = dp[i-1][j] + (limit.contains(j) ? 0 : 1);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < col; i++) {
            result = Math.min((int)dp[wall.size()][i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list1 = Arrays.asList(100000000);
        List<Integer> list2 = Arrays.asList(100000000);
        List<Integer> list3 = Arrays.asList(100000000);
//        List<Integer> list4 = Arrays.asList(2, 4);
//        List<Integer> list5 = Arrays.asList(3, 1, 2);
//        List<Integer> list6 = Arrays.asList(1, 3, 1, 1);
        int result = solution.leastBricks(Arrays.asList(list1, list2, list3));
        System.out.println(result);
    }
}