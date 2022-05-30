package com.liuyuyao.myproject.demo.合并两个链表;
/**
 * @author ：lyy
 * @date ：Created in 2022/5/10 上午9:37
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
    int list1Idx = 0;
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1Idx < a) {
            ++list1Idx;
            ListNode next = mergeInBetween(list1.next, a, b, list2);
            list1.next = next;
            return list1;
        } else if (list1Idx > b) {
            return list1;
        } else {
            if (list2 != null) {
                ListNode next = mergeInBetween(list1, a, b, list2.next);
                list2.next = next;
                return list2;
            }
            ++list1Idx;
            return mergeInBetween(list1.next, a, b, list2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        ListNode list2 = new ListNode(10000);
        list2.next = new ListNode(10001);
        ListNode res = solution.mergeInBetween(list1, 1, 1, list2);
        System.out.println(res);
    }

}
