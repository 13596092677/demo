package com.liuyuyao.myproject.demo.不同的二叉搜索树;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/14 10:09 下午
 * @description：
 */
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
