package com.tegareyn.algorithm.utils;


import com.tegareyn.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/12 17:59
 **/
public class TreeUtil {

    public static TreeNode randomTree() {
        Integer[] array = new Integer[]{55, 30, 77, 20, 36, 60, 80, 17, 23, 34, 40, 57, 63, 79, 81, 15, null, null, 25, null, null, null, null, null, null, null, 67, 78, null, null, null};
        return buildBinaryTree(array);
    }

    // 构造一颗 二叉树
    public static TreeNode buildBinaryTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < array.length) {
            int times = queue.size();
            while (times-- > 0 && index < array.length) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (array[index] != null) {
                    node.left = new TreeNode(array[index]);
                    queue.offer(node.left);
                }
                ++index;
                if (index < array.length && array[index] != null) {
                    node.right = new TreeNode(array[index]);
                    queue.offer(node.right);
                }
                ++index;
            }
        }
        return root;
    }

}
