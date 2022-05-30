package com.liuyuyao.myproject.demo.数组嵌套;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/20 下午8:57
 * @description：
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[nums[i]]) {
                continue;
            }
            int cnt=0;
            ++cnt;
            visited[nums[i]] = true;
            int next = nums[nums[i]];
            while (nums[i] != next) {
                ++cnt;
                visited[nums[next]] = true;
                next = nums[next];
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2});
        System.out.println(res);
    }
}
