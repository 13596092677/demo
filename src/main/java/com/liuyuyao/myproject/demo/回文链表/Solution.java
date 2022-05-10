package com.liuyuyao.myproject.demo.回文链表;

import java.util.Stack;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/7 下午4:35
 * @description：
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        ListNode curr = head;
        while (curr != null) {
            if (!stack.isEmpty() && stack.peek() == curr.val) {
                stack.pop();
            } else {
                stack.push(curr.val);
            }
            curr = curr.next;
            cnt++;
        }
        return cnt == 1 || stack.isEmpty();
    }
}
