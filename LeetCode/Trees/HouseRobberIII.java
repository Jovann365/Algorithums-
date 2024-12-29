package LeetCode.Trees;

/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

Example 1:

Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */

import DataStructures.BTree.TreeNode;

public class HouseRobberIII {
    public static int rob(TreeNode root) {
        int sumEven = robUtil(root, 0, 0);
        int sumOdd = robUtil(root, 0, 1);
        if (sumEven > sumOdd)
            return sumEven;
        return sumOdd;
    }

    public static int robUtil(TreeNode root, int level, int flag) {
        if (root == null) {
            return 0;
        }
        if (flag == 1 && level%2 == 1) {
            flag = 0;
            return root.val;
        }
        if (flag == 0 && level%2 == 0) {
            flag = 1;
            return root.val;
        }
        return robUtil(root.left, level+1, flag) + robUtil(root.right, level+1, flag);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        left1.right = new TreeNode(3);
        right1.right = new TreeNode(1);
        System.out.println(rob(root));
    }
}
