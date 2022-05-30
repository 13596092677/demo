package com.liuyuyao.myproject.demo.数组大小减半;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/23 上午11:26
 * @description：
 */
public class Solution {
    public int minSetSize(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cnt = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            ++cnt[arr[i]];
        }
        Arrays.sort(cnt);
        int count = 0;
        int ans = 0;
        for (int i = cnt.length - 1; i > 0; i--) {
            if (cnt[i] == 0) {
                continue;
            }
            count += cnt[i];
            ++ans;
            if (count >= arr.length >> 1) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minSetSize(new int[]{7, 7, 7, 7, 7, 7});
        System.out.println(res);
    }
}
