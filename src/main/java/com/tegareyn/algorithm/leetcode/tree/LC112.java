package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和
 * @author mocheng
 * @version 1.0
 * @since 2023/9/15 16:33
 **/
public class LC112 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeUtil.buildBinaryTree(array);
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == target;
        }
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }

}
