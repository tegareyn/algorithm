package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值
 * @author mocheng
 * @version 1.0
 * @see LC513
 * @since 2023/12/25 12:59
 **/
public class LC513 {

    public static void main(String[] args) {
        int node = solution(TreeUtil.buildBinaryTree(new Integer[]{1,2,3,4,null,5,6,null,null,7}));
        System.out.println(node);
    }
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result = i == 0 ? node.val : result;
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return result;
    }

    public static int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        // 优化：1.不需要关注层数；2.从右向左添加节点，取出来的最后一个节点即为最后一层的最左节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            result = node.val;
        }
        return result;
    }

}
