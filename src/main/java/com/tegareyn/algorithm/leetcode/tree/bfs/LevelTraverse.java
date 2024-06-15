package com.tegareyn.algorithm.leetcode.tree.bfs;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 15:21
 **/
public class LevelTraverse {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5,2,7,1,4,6,8};
        TreeNode root = TreeUtil.buildBinaryTree(array);
        List<List<Integer>> result = levelTraversal(root);
        System.out.println(result);

    }


    public static List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> sequencePre = new ArrayList<>();
        List<Integer> sequencePreNum = new ArrayList<>();
        sequencePre.add(root);
        sequencePreNum.add(root.val);
        while (!sequencePre.isEmpty()) {
            result.add(sequencePreNum);
            List<TreeNode> sequenceCur = new ArrayList<>();
            List<Integer> sequenceCurNum = new ArrayList<>();
            for (TreeNode node1 : sequencePre) {
                if (node1.left != null) {
                    sequenceCur.add(node1.left);
                    sequenceCurNum.add(node1.left.val);
                }
                if (node1.right != null) {
                    sequenceCur.add(node1.right);
                    sequenceCurNum.add(node1.right.val);
                }
            }
            sequencePre = sequenceCur;
            sequencePreNum = sequenceCurNum;
        }
        return result;
    }

    public static List<TreeNode> flatTreeByLevelTraversal(TreeNode node) {
        List<TreeNode> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        List<TreeNode> sequencePre = new ArrayList<>();
        sequencePre.add(node);
        while (!sequencePre.isEmpty()) {
            result.addAll(sequencePre);
            List<TreeNode> sequenceCur = new ArrayList<>();
            for (TreeNode node1 : sequencePre) {
                if (node1.left != null) {
                    sequenceCur.add(node1.left);
                }
                if (node1.right != null) {
                    sequenceCur.add(node1.right);
                }
            }
            sequencePre = sequenceCur;
        }
        return result;
    }

}
