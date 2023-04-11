package ru.vvikhlyaev.leet.solutions.completed;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * <p>
 * You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.
 * <p>
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
 * <p>
 * Return the head of the modified linked list.
 * <p>
 * Input: head = [0,3,1,0,4,5,2,0]
 * Output: [4,11]
 * Explanation:
 * The above figure represents the given linked list. The modified list contains
 * - The sum of the nodes marked in green: 3 + 1 = 4.
 * - The sum of the nodes marked in red: 4 + 5 + 2 = 11.
 * <p>
 * Input: head = [0,3,1,0,4,5,2,0]
 * Output: [4,11]
 * Explanation:
 * The above figure represents the given linked list. The modified list contains
 * - The sum of the nodes marked in green: 3 + 1 = 4.
 * - The sum of the nodes marked in red: 4 + 5 + 2 = 11.
 */
public class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode resultCurrentNode = result;

        ListNode currentInSource = head;
        int currentSum = 0;

        while (currentInSource != null) {
            if (currentInSource.val != 0) {
                currentSum += currentInSource.val;
                if (resultCurrentNode.val != 0) {
                    ListNode newCurrentResultNode = new ListNode();
                    resultCurrentNode.next = newCurrentResultNode;
                    resultCurrentNode = newCurrentResultNode;
                }
            } else {
                if (currentSum != 0) {
                    resultCurrentNode.val = currentSum;
                    currentSum = 0;
                }
            }
            currentInSource = currentInSource.next;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2181().mergeNodes(init(new int[]{0, 3, 1, 0, 4, 5, 2, 0})));
    }

    private static ListNode init(int[] arr) {
        ListNode result = new ListNode(arr[0]);
        ListNode last = result;
        for (int i = 1; i < arr.length; i++) {
            last.next = new ListNode(arr[i]);
            last = last.next;
        }
        return result;
    }

    private static class ListNode {
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
            return "{" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
