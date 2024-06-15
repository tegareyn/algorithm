package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * @author mocheng
 * @version 1.0
 * @see LC450
 * @since 2024/2/4 14:12
 **/
public class LC450 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{0});
        LC450 lt = new LC450();
        System.out.println(lt.deleteNode(root, 0));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode rooPre = new TreeNode();
        rooPre.right = root;
        TreeNode temp = root;
        TreeNode target = null;
        TreeNode parent = rooPre;
        boolean isLeft = false;
        // 寻找目标节点
        while(temp != null) {
            if (temp.val == key) {
                target = temp;
                break;
            } else if (temp.val > key){
                parent = temp;
                isLeft = true;
                temp = temp.left;
            } else {
                parent = temp;
                isLeft = false;
                temp = temp.right;
            }
        }
        if (target == null) {
            return rooPre.right;
        }

        // 删除目标节点
        if (target.left != null && target.right != null) {
            if (isLeft) {
                parent.left = target.right;
            } else {
                parent.right = target.right;
            }
            TreeNode node = target.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = target.left;
        } else {
            TreeNode node;
            if (target.left == null) {
                node = target.right;
            } else {
                node = target.left;
            }
            if (isLeft) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return rooPre.right;
    }
}
