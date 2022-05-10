package com.liuyuyao.myproject.demo.数组相对排序;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/10 下午5:27
 * @description：
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            hashMap.put(arr2[i], i);
        }
        Integer newNums[] = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (hashMap.containsKey(o1) && hashMap.containsKey(o2)) {
                    return hashMap.get(o1) - hashMap.get(o2);
                } else if (!hashMap.containsKey(o1) && hashMap.containsKey(o2)) {
                    return 1;
                } else if (hashMap.containsKey(o1) && !hashMap.containsKey(o2)) {
                    return -1;
                } else{
                    return o1.intValue() - o2.intValue();
                }
            }
        });
        return Arrays.stream(newNums).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
        System.out.println(res);
    }
}
