package com.liuyuyao.myproject.demo.反转链表II;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/6 10:11 上午
 * @description：
 */
public class Review {
    int index;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        index++;
        if (right == index) {
            return head;
        }
        if (index >= left) {
            ListNode newHead = reverseBetween(head.next, left, right);
            ListNode nxt = head.next.next;
            head.next.next = head;
            head.next = nxt;
            return newHead;
        } else {
            ListNode newHead = reverseBetween(head.next, left, right);
            head.next = newHead;
            return head;
        }
    }
}
