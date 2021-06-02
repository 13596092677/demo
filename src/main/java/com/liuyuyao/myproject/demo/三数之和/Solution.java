package com.liuyuyao.myproject.demo.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : mi
 * create at:  2021/6/2  上午10:34
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            } else {
                for (int left = i + 1, right = nums.length - 1; left < right; ) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < nums.length - 1 && right > i) {
                            if (nums[left + 1] != nums[left] && nums[right - 1] != nums[right]) {
                                // 左指针向右一位,走到第一个不相同元素处
                                // 右指针向左一位,走到第一个不相同元素处
                                left++;
                                right--;
                                break;
                            } else if (nums[left + 1] == nums[left]) {
                                left++; //左指针向右滑到最后一个相同元素处
                            } else if (nums[right - 1] == nums[right]) {
                                right--; //有指针向左滑到最后一个相同元素处
                            }
                        }
                    } else if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
                // 基指针一直向右滑到最后一个相同元素处
                // 因为循环体中自动+1,所以此处不用向右走一位
                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(new int[]{0,0,0,0});
        System.out.println(res);
    }
}