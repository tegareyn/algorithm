package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 * @author mocheng
 * @version 1.0
 * @see LC98
 * @since 2023/12/27 13:09
 **/
public class LC98 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{1,1});
        System.out.println(solution2(root));
    }

    // 用例通过率：75/83。失败：没有大局观
    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return resolve(root.left, root.val, true) && resolve(root.right, root.val, false);
        }
    }

    public static boolean resolve(TreeNode node, int parent, boolean isLeft) {
        if (node == null) {
            return true;
        }
        if ((isLeft && node.val < parent) || (!isLeft && node.val > parent)) {
            return resolve(node.left, node.val, true) && resolve(node.right, node.val, false);
        }
        return false;
    }

    public static boolean solution1(TreeNode root) {
        return resolve1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean resolve1(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val >= upper || node.val <= lower) {
            return false;
        }
        return resolve1(node.left, lower, node.val) && resolve1(node.right, node.val, upper);
    }

    // 中序遍历：根据中序遍历特性，将树进行中序遍历并保存结果，将结果按序比较，如果递增则是二叉搜索树。
    public static boolean solution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        resolve2(root, queue);
        TreeNode node = queue.poll();
        while (queue.size() > 0) {
            TreeNode poll = queue.poll();
            if (poll.val <= node.val) {
                return false;
            }
            node = poll;
        }
        return true;
    }

    public static void resolve2(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            resolve2(node.left, queue);
        }
        queue.add(node);
        if (node.right != null) {
            resolve2(node.right, queue);
        }
    }

    public static boolean solution3(TreeNode root) {
        return resolve3(root, new LinkedList<>());
    }
    public static boolean resolve3(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return true;
        }
        if (node.left != null) {
            resolve2(node.left, queue);
        }
        if (queue.size() > 0) {
            TreeNode poll = queue.poll();
            if (poll.val >= node.val) {
                return false;
            }
        }
        queue.add(node);
        if (node.right != null) {
            resolve2(node.right, queue);
        }
        return true;
    }

}
