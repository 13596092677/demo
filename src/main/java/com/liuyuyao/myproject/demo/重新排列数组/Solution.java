package com.liuyuyao.myproject.demo.重新排列数组;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/23 上午11:43
 * @description：
 */
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        Integer[] idxNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            idxNums[i] = i;
        }
        Arrays.sort(idxNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() < n && o2.intValue() < n) {
                    return o1.compareTo(o2);
                } else if (o1.intValue() >= n && o2.intValue() >= n) {
                    return o1.compareTo(o2);
                } else{
                    if (o1.intValue() < n) {
                        return o1 - (o2 - n) > 0 ? 1 : -1;
                    } else{
                        return o2 - (o1 - n) > 0 ? -1 : 1;
                    }
                }
            }
        });
        return Arrays.stream(idxNums).map(r -> nums[r]).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4);
        System.out.println(Arrays.asList(res));
    }
}
