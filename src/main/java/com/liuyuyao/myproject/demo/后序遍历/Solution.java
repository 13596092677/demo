package com.liuyuyao.myproject.demo.后序遍历;

import com.liuyuyao.myproject.demo.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/17 上午9:13
 * @description：
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // curr表示当前访问到的节点，pre表示最新遍历的节点
        TreeNode curr = root, pre = null;
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            // 如果当前出栈的节点右节点为空或者右节点之前遍历过(和最新遍历的节点相同)
            if (curr.right == null || curr.right == pre) {
                ans.add(curr.val);
                pre = curr;
                curr = null;
            } else{ // 如果当前出栈节点有右节点且没有遍历过
                stack.push(curr);
                curr = curr.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution solution = new Solution();
        List<Integer> res = solution.postorderTraversal(root);
        System.out.println(res);
    }
}
