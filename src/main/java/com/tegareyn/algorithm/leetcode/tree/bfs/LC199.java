package com.tegareyn.algorithm.leetcode.tree.bfs;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：二叉树的右视图
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 16:27
 **/
public class LC199 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(6, new TreeNode(7), new TreeNode(8)));
        System.out.println(traversal(root));
    }


    public static List<Integer> traversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int times = queue.size();
            TreeNode node = null;
            while (times > 0) {
                times--;
                node = queue.poll();
                if (node == null) { break;}
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (node != null) {
                result.add(node.val);
            }
        }
        return result;
    }

}
