package com.liuyuyao.myproject.demo.两两交换链表中的节点;


/**
 * @author ：lyy
 * @date ：Created in 2022/5/11 下午12:04
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
    int idx = 0;
    public ListNode swapPairs(ListNode head) {
        idx++;
        if (head.next == null) {
            return head;
        }
        if (idx % 2 != 0) {
            ListNode newHead = swapPairs(head.next);
            ListNode nxt = head.next.next;
            head.next.next = head;
            head.next = nxt;
            return newHead;
        }
        ListNode next = swapPairs(head.next);
        head.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Solution solution = new Solution();
        ListNode res = solution.swapPairs(head);
        System.out.println(res);
    }
}
