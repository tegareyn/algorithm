package com.tegareyn.algorithm.leetcode.backtrack;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/12 13:40
 **/
public class LC112_3 {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,2,7,1,4,6,8};
        System.out.println(hasPathSum(TreeUtil.buildBinaryTree(array), 8));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        return solution(root, result, path, targetSum).size() > 0;
    }

    /**
     * 按路径遍历，每个不同路径都对应一个List<Integer>
     * 当出现符合要求的List，就放入结果集中
     * 减枝优化：
     *  当List中数据之和已经超过目标数，则不在继续遍历
     *  当遍历左子节点时已经大于目标数，右子节点也不需遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> solution(TreeNode root, List<List<Integer>> result, LinkedList<Integer> path, int target) {
        if (getSum(path) == target) {
            result.add(new ArrayList<>(path));
            return result;
        } else if (getSum(path) > target) {
            return result;
        }

        if (root != null) {
            if (root.left != null) {
                path.add(root.left.val);
                solution(root.left, result, path, target);
                path.removeLast();
            }
            if (root.right != null) {
                path.add(root.right.val);
                solution(root.right, result, path, target);
                path.removeLast();
            }
        }
        return result;
    }

    public static int getSum(List<Integer> path) {
        int sum = 0;
        for (int i : path) {
            sum += i;
        }
        return sum;
    }

}
