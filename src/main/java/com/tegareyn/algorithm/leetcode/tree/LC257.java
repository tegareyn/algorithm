package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述：二叉树的所有路径
 *
 * @author mocheng
 * @version 1.0
 * @see LC257
 * @since 2023/12/23 16:19
 **/
public class LC257 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildBinaryTree(new Integer[]{1, 2, 3, null, 5});
        System.out.println(solution(node));
        System.out.println(solution1(node));
    }

    public static List<String> solution(TreeNode root){
        List<String> result = new ArrayList<>();
        resolve(root, new StringBuilder().append(root.val), result);
        return result;
    }

    public static void resolve(TreeNode node, StringBuilder path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }
        if (node.left != null) {
            resolve(node.left, new StringBuilder(path).append("->").append(node.left.val), result);
        }
        if (node.right != null) {
            resolve(node.right, new StringBuilder(path).append("->").append(node.right.val), result);
        }
    }

    public static List<String> solution1(TreeNode root){
        List<String> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        path.push(root.val);
        resolve1(root, path, result);
        return result;
    }
    public static void resolve1(TreeNode node, Stack<Integer> path, List<String> result) {
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            path.forEach(x -> builder.append("->").append(x));
            builder.delete(0, 2);
            result.add(builder.toString());
            return;
        }
        if (node.left != null) {
            path.push(node.left.val);
            resolve1(node.left, path, result);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            path.push(node.right.val);
            resolve1(node.right, path, result);
            path.remove(path.size() - 1);
        }
    }

}
