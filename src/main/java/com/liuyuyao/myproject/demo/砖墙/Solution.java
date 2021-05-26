package com.liuyuyao.myproject.demo.砖墙;

import java.util.*;

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
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (List<Integer> list : wall) {
            int total = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                total += list.get(i);
                if (timesMap.containsKey(total)) {
                    timesMap.put(total, timesMap.get(total) + 1);
                } else timesMap.put(total, 1);
            }
        }
        int len = 0;
        for (int i = 0; i < wall.get(0).size(); i++) {
            len += wall.get(0).get(i);
        }
        int result = wall.size();
        for (Integer key : timesMap.keySet()) {
            Integer integer = timesMap.get(key);
            result = Math.min(result, wall.size() - integer);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> list2 = Arrays.asList(3, 1, 2);
        List<Integer> list3 = Arrays.asList(1, 3, 2);
        List<Integer> list4 = Arrays.asList(2, 4);
        List<Integer> list5 = Arrays.asList(3, 1, 2);
        List<Integer> list6 = Arrays.asList(1, 3, 1, 1);
        int result = solution.leastBricks(Arrays.asList(list1, list2, list3, list4, list5, list6));
        System.out.println(result);
    }
}