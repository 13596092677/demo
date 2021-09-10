package com.liuyuyao.myproject.demo.优美的排列;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/10 9:07 上午
 * @description：
 */
public class Solution1 {
    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            // num代表放入待定数组的位置，同idx+1
            int num = Integer.bitCount(mask);
            // 从1~n中选取整数放入待定数组
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    // f[mask]=所有前num-1个位置都已放置了数的方案和
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.countArrangement(4);
        System.out.println(res);
    }
}
