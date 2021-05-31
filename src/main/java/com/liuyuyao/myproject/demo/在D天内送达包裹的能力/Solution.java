package com.liuyuyao.myproject.demo.在D天内送达包裹的能力;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author : mi
 * create at:  2021/5/28  下午2:14
 * @description: 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int height = Arrays.stream(weights).sum();
        int result = height;
        while (low <= height) {
            int mid = (low + height) / 2;
            if (check(weights, mid, days)) {
                result = mid;
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    boolean check(int[] weights, int maxWeight, int days) {
        int tempWeight = maxWeight;
        for (int i = 0; i < weights.length; i++) {
            if (tempWeight >= weights[i]) {
                tempWeight -= weights[i];
            } else {
                days--;
                tempWeight = maxWeight;
                tempWeight -= weights[i];
            }
        }
        return days >= 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
        System.out.println(res);
    }
}