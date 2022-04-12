package com.liuyuyao.myproject.demo.反转链表;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/7 下午3:10
 * @description：
 */
public class Review1 {
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode newHead = reverseList(head.next);
            newHead.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
