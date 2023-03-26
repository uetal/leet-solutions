package ru.vvikhlyaev.leet.solutions;

import java.util.List;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Example 1:
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */

public class Solution021 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list1Next = null;
        ListNode list2Next = null;

        ListNode result = null;
        ListNode lastResult = null;

        list1Next = list1;
        list2Next = list2;

        while (true) {
            if (list1Next == null & list2Next == null) {
                break;
            }
            if (list1Next == null) {
                if (result == null) {
                    result = list2Next;
                    lastResult = list2Next;
                    list2Next = list2Next.next;
                    continue;
                }
                if (lastResult == null) {
                    lastResult = list2Next;
                } else {
                    lastResult.next = list2Next;
                }
                list2Next = list2Next.next;
                continue;
            }

            if (list2Next == null) {
                if (result == null) {
                    result = list1Next;
                    lastResult = list1Next;
                    list1Next = list1Next.next;
                    continue;
                }
                if (lastResult == null) {
                    lastResult = list1Next;
                } else {
                    lastResult.next = list1Next;
                }
                list1Next = list1Next.next;
                continue;
            }

            if (result == null) {
                if (list1Next.val < list2Next.val) {
                    result = list1Next;
                    lastResult = list1Next;
                    list1Next = list1Next.next;
                } else {
                    result = list2Next;
                    lastResult = list2Next;
                    list2Next = list2Next.next;
                }
                continue;
            }
            if (lastResult != null) {
                if (list1Next.val < list2Next.val) {
                    lastResult.next = list1Next;
                    lastResult = list1Next;
                    list1Next = list1Next.next;
                } else {
                    lastResult.next = list2Next;
                    lastResult = list2Next;
                    list2Next = list2Next.next;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(mergeTwoLists(new ListNode(0), new ListNode(1)));
//        System.out.println(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4)))));
//        System.out.println(mergeTwoLists(null, new ListNode(0)));
        System.out.println(mergeTwoLists(new ListNode(-9, new ListNode(3)), new ListNode(5, new ListNode(7))));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
