package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：根据中序、后序遍历结果构造二叉树
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/19 12:27
 **/
public class LC106_2 {

    public static void main(String[] args) {
        TreeNode solution = solution(
                new int[]{15, 17, 20, 23, 25, 30, 34, 36, 40, 55, 57, 60, 63, 67, 77, 78, 79, 80, 81},
                new int[]{15, 17, 25, 23, 20, 34, 40, 36, 30, 57, 67, 63, 60, 78, 79, 81, 80, 77, 55});
        System.out.println(solution);
    }

    public static TreeNode solution(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return buildTree(map,
                inOrder, 0, inOrder.length - 1,
                postOrder, 0, postOrder.length - 1);
    }

    public static TreeNode buildTree(Map<Integer, Integer> map, int[] inOrder, int inBegin, int inEnd,
                                     int[] postOrder, int postBegin, int postEnd) {
        int rootVal = postOrder[postBegin];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(map,
                inOrder, 0, rootIndex,
                postOrder, postBegin, postBegin + rootIndex);
        root.right = buildTree(map,
                inOrder, rootIndex + 1, inEnd,
                postOrder, rootIndex + 1, postEnd - 1);
        return root;
    }
}
