package com.liuyuyao.myproject.demo.反转链表II;

/**
 * @author ：lyy
 * @date ：Created in 2021/7/28 11:01 上午
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
    int index;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        index++;
        if (head == null || head.next == null) {
            return head;
        }
        if (index == right) {
            return head;
        }
        if (index >= left) {
            ListNode newHead = reverseBetween(head.next, left, right);
            ListNode nxt=head.next.next;
            head.next.next = head;
            head.next = nxt;
            return newHead;
        } else{
            ListNode next = reverseBetween(head.next, left, right);
            head.next = next;
            return head;
        }
    }
}
