package ru.vvikhlyaev.leet.solutions.completed;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * reeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * <p>
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * Example 2:
 * <p>
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */
public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        addToMap(map, root, 0);
        int maxDeep = map.keySet().stream().flatMapToInt(IntStream::of).max().getAsInt();
        return map.get(maxDeep).stream().map(x->x.val).flatMapToInt(IntStream::of).sum();
    }

    private void addToMap(Map<Integer, List<TreeNode>> map, TreeNode treeNode, Integer deep) {
        if (treeNode == null)
            return;
        map.merge(deep, Arrays.asList(treeNode), (x, y) -> Stream.concat(x.stream(), y.stream()).toList());
        int deepForChild = ++deep;
        addToMap(map, treeNode.left, deepForChild);
        addToMap(map, treeNode.right, deepForChild);
    }

    public static void main(String[] args) {
        var firstRes = check(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(
                                        4,
                                        new TreeNode(7),
                                        null
                                ),
                                new TreeNode(5)
                        ),
                        new TreeNode(
                                3,
                                null,
                                new TreeNode(
                                        6,
                                        null,
                                        new TreeNode(8)
                                )
                        )
                ),
                15
        );
        System.out.println(firstRes);
        var secondRes = check(
                new TreeNode(
                        6,
                        new TreeNode(
                                7,
                                new TreeNode(
                                        2,
                                        new TreeNode(9),
                                        null
                                ),
                                new TreeNode(
                                        7,
                                        new TreeNode(1),
                                        new TreeNode(4)
                                )
                        ),
                        new TreeNode(
                                8,
                                new TreeNode(
                                        1,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        3,
                                        null,
                                        new TreeNode(5)
                                )
                        )
                ),
                19
        );
        System.out.println(secondRes);
    }

    public static boolean check(TreeNode treeNode, int expectedResult) {
        var res = new Solution1302().deepestLeavesSum(treeNode);
        System.out.println(res);
        return res == expectedResult;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


