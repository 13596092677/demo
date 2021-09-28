package com.liuyuyao.myproject.demo.路径总和III;

import com.liuyuyao.myproject.demo.TreeNode.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/28 10:22 上午
 * @description：
 */
public class Solution {
    Map<Integer, Integer> hashMap = new HashMap<>();
    int ans;
    public int pathSum(TreeNode root, int targetSum) {
        hashMap.put(0, 1);
        dfs(root, targetSum, 0);
        return ans;
    }

    void dfs(TreeNode root, int target, int sum) {
         if (root == null) {
            return;
        }
        ans += hashMap.getOrDefault((sum + root.val) - target, 0);
        hashMap.put(sum + root.val, hashMap.getOrDefault(sum + root.val, 0) + 1);
        dfs(root.left, target, sum + root.val);
        dfs(root.right, target, sum + root.val);
        hashMap.put(sum + root.val, hashMap.get(sum + root.val) - 1);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(-2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int res = new Solution().pathSum(root, 22);
        System.out.println(res);
    }
}
