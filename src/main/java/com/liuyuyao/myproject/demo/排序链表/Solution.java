package com.liuyuyao.myproject.demo.排序链表;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/13 下午12:21
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
    public ListNode sortList(ListNode head) {
        if (head==null||head.next == null) {
            return head;
        }
        ListNode next = sortList(head.next);
        ListNode curr = next.next;
        ListNode pre = next;
        if (head.val <= pre.val) {
            head.next = pre;
            return head;
        }
        while (pre != null) {
            if ((curr == null && pre.val <= head.val) || (curr != null && head.val <= curr.val)) {
                pre.next = head;
                head.next = curr;
                return next;
            }
            curr = curr.next;
            pre = pre.next;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode res = solution.sortList(head);
        System.out.println(res);
    }
}
