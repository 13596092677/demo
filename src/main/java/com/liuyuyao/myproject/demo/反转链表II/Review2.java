package com.liuyuyao.myproject.demo.反转链表II;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/12 下午4:12
 * @description：
 */
public class Review2 {
    int idx;
    public ListNode reverseBetween(ListNode head, int left, int right){
        idx++;
        if (right == idx) {
            return head;
        } else if (idx < left) {
            ListNode next = reverseBetween(head.next, left, right);
            head.next = next;
        } else{
            ListNode tail = reverseBetween(head.next, left, right);
            ListNode next = head.next.next;
            head.next.next = head;
            head.next = next;
            return tail;
        }
        return head;
    }
}
