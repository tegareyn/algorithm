package com.tegareyn.algorithm.leetcode.backtrack;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.LinkedList;

/**
 * 描述：寻找是否存在根到叶节点路径上的值和为目标数
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/12 14:27
 **/
public class LC112 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeUtil.buildBinaryTree(array);
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        return solution(root, path, targetSum);
    }

    public static boolean solution(TreeNode root, LinkedList<Integer> path, int target) {
        // 当前path中最后一个节点如果是叶节点时，若路径上节点值和为目标数，则返回true
        if (root.left == null && root.right == null) {
            return root.val == target;
        }
        boolean solution;
        if (root.left != null) {
            path.add(root.left.val);
            solution = solution(root.left, path, target - root.val);
            if(solution) return true;
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right.val);
            solution = solution(root.right, path, target - root.val);
            if(solution) return true;
            path.removeLast();
        }
        return false;
    }
}
