package com.tegareyn.algorithm.model;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @ClassName TreeNode
 * @Description leetcode 二叉树定义
 * @Author mocheng
 * @Since 2022/11/26 22:31
 * @Version 1.0
 **/

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int value() {
        return this.val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return levelOrder();
    }

    // 前序遍历
    private void preOrder(TreeNode node, StringBuilder sb){
        if (node != null) {
            sb.append(node.val).append(", ");
            if (node.left != null) {
                preOrder(node.left, sb);
            }
            if (node.right != null) {
                preOrder(node.right, sb);
            }
        }
    }

    // 中序遍历
    private void inOrder(TreeNode node, StringBuilder sb){
        if (node != null) {
            if (node.left != null) {
                inOrder(node.left, sb);
            }
            sb.append(node.val).append(", ");
            if (node.right != null) {
                inOrder(node.right, sb);
            }
        }
    }

    // 后序遍历
    private void postOrder(TreeNode node, StringBuilder sb){
        if (node != null) {
            if (node.left != null) {
                postOrder(node.left, sb);
            }
            if (node.right != null) {
                postOrder(node.right, sb);
            }
            sb.append(node.val).append(", ");
        }
    }

    // 层序遍历
    private String levelOrder(){
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null == node) {
                    sb.append("null, ");
                    continue;
                } else {
                    sb.append(node.val).append(", ");
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.append("]");
        String s = sb.toString().replaceAll(", ]", "]");
        while (s.endsWith(", null]")) {
            s = s.replaceAll(", null]", "]");
        }
        return s;
    }
}
