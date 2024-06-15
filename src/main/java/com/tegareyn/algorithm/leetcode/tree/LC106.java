package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：从中序和后序遍历结果构造二叉树
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/16 20:11
 **/
public class LC106 {

//                        55
//           30                         77
//    20             36              60           80
//  17  23        34    40       57    63     79     81
//15       25                       67  78
// [55, 30, 77, 20, 36, 60, 80, 17, 23, 34, 40, 57, 63, 79, 81, 15, null, null, 25, null, null, null, null, null, null, null, 67, 78, null, null, null]

//    前序遍历： [55, 30, 20, 17, 15, 23, 25, 36, 34, 40, 77, 60, 57, 63, 67, 80, 79, 78, 81]


//    中序遍历： [15, 17, 20, 23, 25, 30, 34, 36, 40, 55, 57, 60, 63, 67, 77, 78, 79, 80, 81]
//    后序遍历： [15, 17, 25, 23, 20, 34, 40, 36, 30, 57, 67, 63, 60, 78, 79, 81, 80, 77, 55]
    // 第一次 前序  15, 17, 20, 23, 25, 30, 34, 36, 40     55      57, 60, 63, 67, 77, 78, 79, 80, 81
    // 后序  15, 17, 25, 23, 20, 34, 40, 36, 30      57, 67, 63, 60, 78, 79, 81, 80, 77

    public static void main(String[] args) {
        TreeNode solution = solution(
                new int[]{15, 17, 20, 23, 25, 30, 34, 36, 40, 55, 57, 60, 63, 67, 77, 78, 79, 80, 81},
                new int[]{15, 17, 25, 23, 20, 34, 40, 36, 30, 57, 67, 63, 60, 78, 79, 81, 80, 77, 55});
        System.out.println(solution);
    }
    public static TreeNode solution(int[] inTraverse, int[] postTraverse) {
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < inTraverse.length; i++) {
            position.put(inTraverse[i], i);
        }
        return buildTree(position, inTraverse, 0, inTraverse.length,
                postTraverse, 0, postTraverse.length);
    }

    public static TreeNode buildTree(Map<Integer, Integer> position, int[] inTraverse, int inBegin, int inEnd, int[] postTraverse, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        int rootIndex = position.get(postTraverse[postEnd - 1]);
        TreeNode node = new TreeNode(inTraverse[rootIndex]);
        int leftLength = rootIndex - inBegin;
        node.left = buildTree(position,
                inTraverse, inBegin, rootIndex,
                postTraverse, postBegin, postBegin + leftLength);
        node.right = buildTree(position,
                inTraverse, rootIndex + 1, inEnd,
                postTraverse, postBegin + leftLength, postEnd - 1);
        return node;
    }
}
