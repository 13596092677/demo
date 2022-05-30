package com.liuyuyao.myproject.demo.调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/21 下午4:51
 * @description：
 */
public class Solution {
    public int[] exchange(int[] nums) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((o1.intValue() - o2.intValue()) % 2 == 0) {
                    return o1.intValue() - o2.intValue();
                } else{
                    boolean odd = (o1.intValue()) % 2 == 1;
                    if (odd) {
                        return -1;
                    } else{
                        return 1;
                    }
                }
            }
        });
        return Arrays.stream(newNums).mapToInt(Integer::valueOf).toArray();
    }
}
