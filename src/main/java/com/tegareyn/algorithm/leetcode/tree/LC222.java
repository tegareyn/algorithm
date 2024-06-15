package com.tegareyn.algorithm.leetcode.tree;


import com.tegareyn.algorithm.model.TreeNode;

import java.util.LinkedList;

/**
 * 描述：完全二叉树求节点树
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/10 09:58
 **/
public class LC222 {

    public static int bfs(TreeNode root) {
        LinkedList<TreeNode> container = new LinkedList<>();
        int result = 0;
        if (root == null) {
            return result;
        }
        container.offer(root);
        while (!container.isEmpty()) {
            int size = container.size();
            result += size;
            while (size-- > 0 ) {
                TreeNode poll = container.poll();
                if (poll == null) {
                    break;
                }
                if (poll.left != null) {
                    container.offer(poll.left);
                }
                if (poll.right != null) {
                    container.offer(poll.right);
                }
            }
        }
        return result;
    }
}
