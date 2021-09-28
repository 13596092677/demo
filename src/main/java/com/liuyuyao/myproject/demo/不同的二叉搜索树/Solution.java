package com.liuyuyao.myproject.demo.不同的二叉搜索树;

import com.liuyuyao.myproject.demo.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/14 10:08 下午
 * @description：
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        int[] list = new int[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        return make(list, 0, n);
    }

    List<TreeNode> make(int[] list, int from, int to) {
        List<TreeNode> rootTree = new ArrayList<>();
        if (from == to) {
            rootTree.add(null);
            return rootTree;
        }
        for (int i = from; i < to; i++) {
            List<TreeNode> leftTree = make(list, from, i);
            List<TreeNode> rightTree = make(list, i + 1, to);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode root = new TreeNode(list[i]);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    rootTree.add(root);
                }
            }
        }
        return rootTree;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> res = solution.generateTrees(3);
        System.out.println(res);
    }
}
