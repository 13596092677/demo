package com.liuyuyao.myproject.demo.从根到叶的二进制数之和;

import com.liuyuyao.myproject.demo.TreeNode.TreeNode;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/30 上午9:52
 * @description：
 */
public class Solution {
    StringBuffer sb=new StringBuffer();
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(sb.toString(), 2);
            return;
        }
        dfs(root.left);
        dfs(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        Solution solution = new Solution();
        int res = solution.sumRootToLeaf(root);
        System.out.println(res);
    }
}
