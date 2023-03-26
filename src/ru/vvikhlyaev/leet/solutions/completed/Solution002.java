package ru.vvikhlyaev.leet.solutions.completed;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution002
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode listNode = new ListNode();
        int firstOperand = l1 == null ? 0 : l1.val;
        int secondOperand = l2 == null ? 0 : l2.val;
        int sum = firstOperand + secondOperand;
        if (sum >= 10) {
            listNode.val = sum - 10;
            if (l1 != null) {
                if (l1.next != null) {
                    l1.next.val += 1;
                } else {
                    l1.next = new ListNode(1);
                }
            } else {
                if (l2.next != null) {
                    l2.next.val += 1;
                } else {
                    l2 = new ListNode(0, new ListNode(1));
                }
            }
        } else {
            listNode.val = sum;
        }
        listNode.next = addTwoNumbers(l1 == null ? null: l1.next, l2 == null? null : l2.next);
        return listNode;
    }

    public static void main(String[] args) {
        Solution002 atn = new Solution002();
//        atn.test(new ListNode(1, new ListNode(4)), new ListNode(2));
//        atn.test(new ListNode(2, new ListNode(4, new ListNode(3))),
//                new ListNode(5, new ListNode(6, new ListNode(4)))); //708
        atn.test(new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));///89990001
    }

    public void test(ListNode l1, ListNode l2) {
        System.out.println(this.collectAllNodesValInArrayFormat(l1, new ArrayList<>()));
        System.out.println(this.collectAllNodesValInArrayFormat(l2, new ArrayList<>()));
        System.out.println(this.collectAllNodesValInArrayFormat(this.addTwoNumbers(l1, l2), new ArrayList<>()));
        System.out.println("------------------");
    }

    public List<Integer> collectAllNodesValInArrayFormat(ListNode listNode, List<Integer> list) {
        if (listNode != null) {
            list.add(listNode.val);
            return collectAllNodesValInArrayFormat(listNode.next, list);
        } else {
            return list;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
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
