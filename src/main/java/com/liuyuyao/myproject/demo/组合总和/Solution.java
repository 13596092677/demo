package com.liuyuyao.myproject.demo.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : mi
 * create at:  2021/6/11  下午3:32
 * @description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List[] resDp = new List[target+1];
        for (int i = 0; i <= target; i++) {
            resDp[i] = new ArrayList<ArrayList<Integer>>();
        }
        resDp[0].add(new ArrayList<Integer>());
        for (int i = 0; i < candidates.length; i++) {
            for (int j = candidates[i]; j <= target; j++) {
                    for (int k = 0; k < resDp[j - candidates[i]].size(); k++) {
                        List<Integer> curList = (List<Integer>) resDp[j - candidates[i]].get(k);
                        List<Integer> copyList=new ArrayList(curList);
                        copyList.add(candidates[i]);
                        resDp[j].add(copyList);
                    }
            }
        }
        return resDp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(new int[]{186, 419, 83, 408}, 6249);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}