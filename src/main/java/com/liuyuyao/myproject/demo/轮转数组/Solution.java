package com.liuyuyao.myproject.demo.轮转数组;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/21 下午3:04
 * @description：
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            int first = nums[i];
            int next = (i + k) % (nums.length);
            int prev = nums[i];
            while (nums[next] != first) {
                int curr = nums[next];
                nums[next] = prev;
                visited[next] = true;
                prev = curr;
                next = (next + k) % (nums.length);
            }
            nums[next] = prev;
            visited[next] = true;
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
            solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}

