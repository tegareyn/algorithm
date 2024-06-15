package com.tegareyn.algorithm.leetcode.backtrack;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.LinkedList;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/14 23:19
 **/
public class LC112_2 {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeUtil.buildBinaryTree(array);
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        LinkedList<TreeNode> path = new LinkedList<>();
        path.add(root);
        return solution(path, root, target);
    }

    public static boolean solution(LinkedList<TreeNode> path, TreeNode root, int target) {
        if (findPath(path, target)) {
            return true;
        }
        boolean flag;
        if (root.left != null) {
            path.add(root.left);
            flag = solution(path, root.left, target);
            if (flag) {
                return true;
            }
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right);
            flag = solution(path, root.right, target);
            if (flag) {
                return true;
            }
            path.removeLast();
        }

        return false;
    }

    public static boolean findPath(LinkedList<TreeNode> path, int target) {
        if (path == null || path.isEmpty()) {
            return false;
        }
        TreeNode last = path.getLast();
        if (last.right == null && last.left == null) {
            final int[] sum = {0};
            path.forEach(treeNode -> sum[0] += treeNode.val);
            return sum[0] == target;
        }
        return false;
    }

}
