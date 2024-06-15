package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。
 * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
 * @author mocheng
 * @version 1.0
 * @see LC617
 * @since 2023/12/27 12:27
 **/
public class LC617 {

    public static void main(String[] args) {
        TreeNode node1 = TreeUtil.buildBinaryTree(new Integer[]{});
        TreeNode node2 = TreeUtil.buildBinaryTree(new Integer[]{1});
        System.out.println(solution(node1, node2));
    }

    public static TreeNode solution(TreeNode root1, TreeNode root2) {
        TreeNode result = new TreeNode();
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            resolve(root1, root2, result);
            return result;
        }
    }

    public static TreeNode resolve(TreeNode node1, TreeNode node2, TreeNode result) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else {
            result.val = node1.val + node2.val;
            result.left = new TreeNode();
            result.left = resolve(node1.left, node2.left, result.left);
            result.right = new TreeNode();
            result.right = resolve(node1.right, node2.right, result.right);
        }
        return result;
    }
}
