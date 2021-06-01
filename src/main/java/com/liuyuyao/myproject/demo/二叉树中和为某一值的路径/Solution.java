package com.liuyuyao.myproject.demo.二叉树中和为某一值的路径;

/**
 * @author : mi
 * create at:  2021/6/1  上午10:11
 * @description:
 */

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        curList.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                res.add(new ArrayList<>(curList));
            }
        }
        pathSum(root.left, target);
        pathSum(root.right, target);
        curList.remove(curList.size() - 1);
        return res;
    }

    static int index = 0;
    TreeNode buildTree(int[] nums) {
        if (nums[index] == 0) {
            index++;
            return null;
        }
        TreeNode rootNode = new TreeNode(nums[index++]);
        TreeNode leftNode = buildTree(nums);
        TreeNode rightNode = buildTree(nums);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode rootNode = solution.buildTree(new int[]{5, 4, 11, 7, 0, 0, 2, 0, 0, 0, 8, 13, 0, 0, 4, 5, 0, 0, 1, 0, 0});
        System.out.println(rootNode);
        List<List<Integer>> res = solution.pathSum(rootNode, 22);
        System.out.println(res);
    }
}