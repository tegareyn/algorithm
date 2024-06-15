package com.tegareyn.algorithm.leetcode.tree.bfs;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：二叉树的层序遍历
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 16:25
 **/
public class LC102 {
    /**
     * 自顶向下按层遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 先进先出
        queue.offer(root);
        while(!queue.isEmpty()) {
            int time = queue.size();
            List<Integer> item = new ArrayList<>();
            while (time > 0) {
                time--;
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                item.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(item);
        }
        return result;
    }

}
