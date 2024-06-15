package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述：所有可能的真二叉树
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 *
 * @author mocheng
 * @version 1.0
 * @see LC894
 * @since 2024/4/2 13:10
 **/
public class LC894 {

    public static void main(String[] args) {
        List<TreeNode> result = allPossibleFBT(7);
        System.out.println(result.size());
        for (TreeNode root: result) {
            System.out.println(root);
        }
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            return result;
        }
        List<TreeNode> pageNodes = Collections.singletonList(new TreeNode(0));
        if (n == 1) {
            return pageNodes;
        } else {
            for (int i = 1; i < n; i += 2) {
                List<TreeNode> leftSubtrees = allPossibleFBT(i);
                List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - i);
                for (TreeNode leftSubtree : leftSubtrees) {
                    for (TreeNode rightSubtree : rightSubtrees) {
                        TreeNode root = new TreeNode(0, leftSubtree, rightSubtree);
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }

    public static void solution(int n, List<TreeNode> pageNodes, List<TreeNode> result) {
        if (n == 0) {
            return;
        }
        List<TreeNode> newPageNodes = new ArrayList<>();
        for (TreeNode node : pageNodes) {
            TreeNode left = new TreeNode(0);
            TreeNode right = new TreeNode(0);
            newPageNodes.add(left);
            newPageNodes.add(right);
            node.left = left;
            node.right = right;
        }
        solution(n - 2, newPageNodes, result);
    }
}
