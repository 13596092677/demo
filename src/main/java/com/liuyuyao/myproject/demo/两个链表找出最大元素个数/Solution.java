package com.liuyuyao.myproject.demo.两个链表找出最大元素个数;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/27 上午11:19
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
    int findMaxCountItemInLinkedList(ListNode list1, ListNode list2) {
        ListNode newList = mergeLinkedList(list1, list2);
        ListNode left = newList;
        ListNode right = newList;
        int item = 0;
        int ans = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        while (left != null && right != null) {
            while (right.next != null && right.next.val == right.val) {
                right = right.next;
                ++rightIdx;
            }

            if (rightIdx - leftIdx + 1 > ans) {
                ans = rightIdx - leftIdx + 1;
                item = right.val;
            }
            while (left.next != null && left.next.val == left.val) {
                left = left.next;
                ++leftIdx;
            }
            left = left.next;
            right = right.next;
            ++leftIdx;
            ++rightIdx;
        }
        return ans;

    }

    ListNode mergeLinkedList(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list2 == null && list1 != null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeLinkedList(list1.next, list2);
            return list1;
        } else{
            list2.next = mergeLinkedList(list1, list2.next);
            return list2;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(1);
        int res = solution.findMaxCountItemInLinkedList(listNode1, listNode2);
        System.out.println(res);
    }
}
