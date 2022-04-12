package com.liuyuyao.myproject.demo.反转链表II;

import sun.security.x509.InvalidityDateExtension;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/7 下午3:26
 * @description：
 */
public class Review1 {
    int idx;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        idx++;
        if (idx == right) {
            return head;
        } else if (idx >= left) {
            ListNode newHead = reverseBetween(head.next, left, right);
            ListNode tail = head.next.next;
            head.next.next = head;
            head.next = tail;
            return newHead;
        } else{
            ListNode newHead = reverseBetween(head.next, left, right);
            head.next = newHead;
            return head;
        }
    }
}
