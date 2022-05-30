package com.liuyuyao.myproject.demo.乘法表中第k小的数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/18 上午11:06
 * @description：
 */
public class Solution <T extends Integer>{
    public Solution(T key) {
        this.key = key;
    }

    public Solution(){

    }
    T key;
    public int findKthNumber(int m, int n, int k) {
        int[] curr = new int[m];
        int cnt = 0;
        while(true) {
            int pos = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (curr[i] == n) {
                    continue;
                }
                if ((curr[i] + 1) * (i + 1) <= min) {
                    min = (curr[i] + 1) * (i + 1);
                    pos = i;
                }
            }
            if (++cnt == k) {
                return min;
            }
            ++curr[pos];
        }
    }

    static <T> Class<T> getClass1() {
        Supplier<List<T>> aNew = ArrayList::new;
        return null;
    }



    public static void main(String[] args) {
//        Solution solution = new Solution<>("123");
//
//        int res = solution.findKthNumber(3, 6, 10);
//        System.out.println(res);
        Solution<Integer> solution = new Solution<Integer>();
        solution.getClass1();
    }

}
