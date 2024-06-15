package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 在修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * @author mocheng
 * @version 1.0
 * @see LC669
 * @since 2024/2/4 19:38
 **/
public class LC669 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{45,30,46,10,36,null,49,8,24,34,42,48,null,4,9,14,25,31,35,41,43,47,null,0,6,null,null,11,20,null,28,null,33,null,null,37,null,null,44,null,null,null,1,5,7,null,12,19,21,26,29,32,null,null,38,null,null,null,3,null,null,null,null,null,13,18,null,null,22,null,27,null,null,null,null,null,39,2,null,null,null,15,null,null,23,null,null,null,40,null,null,null,16,null,null,null,null,null,17});
        LC669 lc = new LC669();
        System.out.println(root);
        System.out.println(lc.trimBST(root, 32, 44));
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode ancestor = new TreeNode();
        ancestor.left = root;
        findLowTurn(ancestor, ancestor.left, low);
        findHighTurn(ancestor, ancestor.left, true, high);
        return ancestor.left;
    }

    private void findLowTurn(TreeNode parent, TreeNode root, int low) {
        if (root == null) {
            return;
        }
        if (root.val > low) {
            findLowTurn(root, root.left, low);
        } else if (root.val == low) {
            root.left = null;
        } else {
            parent.left = root.right;
        }
    }


    private void findHighTurn(TreeNode parent, TreeNode root, boolean isLeft, int high) {
        if (root == null) {
            return;
        }
        if (root.val < high) {
            findHighTurn(root, root.right, false, high);
        } else {
            findHighTurn(root, root.left, true, high);
            if (root.val == high) {
                root.right = null;
            } else {
                if (isLeft) {
                    parent.left = root.left;
                } else {
                    parent.right = root.left;
                }
            }
        }
    }
}
