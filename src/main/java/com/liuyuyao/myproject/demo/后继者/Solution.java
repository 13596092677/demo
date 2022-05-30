package com.liuyuyao.myproject.demo.后继者;

import com.liuyuyao.myproject.demo.TreeNode.TreeNode;

import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/16 上午10:15
 * @description：
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        TreeNode ans = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        boolean flag = false;
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null && !visited.contains(peek.left)) {
                stack.push(peek.left);
                continue;
            }
            // 顶部元素出栈
            TreeNode pop = stack.pop();
            visited.add(pop);
            if (flag) {
                ans = pop;
                break;
            }
            if (pop == p) {
                flag = true;
            }
            if (pop.right != null && !visited.contains(peek.right)) {
                stack.push(pop.right);
            }
        }
        return ans;
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(2);
        TreeNode res = solution.inorderSuccessor(root, root.right);
        System.out.println(res.val);
    }
}
