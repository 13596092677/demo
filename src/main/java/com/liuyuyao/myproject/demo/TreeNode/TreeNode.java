package com.liuyuyao.myproject.demo.TreeNode;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/28 10:23 上午
 * @description：
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
