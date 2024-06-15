package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和
 * @author mocheng
 * @version 1.0
 * @see LC112_2
 * @since 2023/12/27 11:44
 **/
public class LC112_2 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeUtil.buildBinaryTree(array);
        System.out.println(solution(root, 22));
    }
    public static boolean solution(TreeNode root, int target) {
        return dfs(root, target, 0);
    }

    public static boolean dfs(TreeNode node, int target, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return sum + node.val == target;
        }

        return dfs(node.left, target, sum + node.val) || dfs(node.right, target, sum + node.val);
    }

}
