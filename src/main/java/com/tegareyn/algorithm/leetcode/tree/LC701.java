package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：二叉搜索树的插入位置
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * @author mocheng
 * @version 1.0
 * @see LC701
 * @since 2024/2/4 12:23
 **/
public class LC701 {

    public static void main(String[] args) {
        LC701 lt = new LC701();
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{40,20,60,10,30,50,70});
        System.out.println(root);
        lt.insertIntoBST2(root, 25);
        System.out.println(root);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insertInto(root, val);
        return root;
    }

    // 递归法
    public void insertInto(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else
                insertInto(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else
                insertInto(root.right, val);
        }
    }

    // 迭代法
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode result = root;
        TreeNode node = new TreeNode(val);
        while (true) {
            if (root.val > val) {
                if (root.left == null) {
                    root.left = node;
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right == null) {
                    root.right = node;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return result;
    }
}
