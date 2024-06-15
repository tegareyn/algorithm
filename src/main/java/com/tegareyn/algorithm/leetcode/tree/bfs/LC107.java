package com.tegareyn.algorithm.leetcode.tree.bfs;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：二叉树的层序遍历 II
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 16:26
 **/
public class LC107 {
    /**
     * 自底向上按层遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(); // 特殊用法，可以在头尾前后添加元素
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
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
            result.add(0, item); // 在0下标位置的元素前添加元素
        }
        return result;
    }


}
