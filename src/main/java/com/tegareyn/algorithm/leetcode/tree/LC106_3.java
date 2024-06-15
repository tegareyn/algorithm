package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：根据后序和中序遍历结果重构二叉树
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/10/1 12:49
 **/
public class LC106_3 {

    public static void main(String[] args) {
        TreeNode solution = build(
                new int[]{15, 17, 20, 23, 25, 30, 34, 36, 40, 55, 57, 60, 63, 67, 77, 78, 79, 80, 81},
                new int[]{15, 17, 25, 23, 20, 34, 40, 36, 30, 57, 67, 63, 60, 78, 79, 81, 80, 77, 55});
        System.out.println(solution);
    }

    public static TreeNode build(int[] inOrders, int[] postOrders) {
        Map<Integer, Integer> index = new HashMap<>();
        int i = 0;
        for (int x : inOrders) {
            index.put(x, i++);
        }
        return rebuild(index,
                inOrders, 0, inOrders.length - 1,
                postOrders, 0, postOrders.length - 1);
    }

    //    中序遍历： [15, 17, 20, 23, 25, 30, 34, 36, 40, 55, 57, 60, 63, 67, 77, 78, 79, 80, 81]
    //    后序遍历： [15, 17, 25, 23, 20, 34, 40, 36, 30, 57, 67, 63, 60, 78, 79, 81, 80, 77, 55]
    // 第一次                                      9
    // 前序  15, 17, 20, 23, 25, 30, 34, 36, 40     55      57, 60, 63, 67, 77, 78, 79, 80, 81
    // 后序  15, 17, 25, 23, 20, 34, 40, 36, 30      57, 67, 63, 60, 78, 79, 81, 80, 77

    // 第二次：
    // 前序:  15, 17, 20, 23, 25, 30, 34, 36, 40
    // 后序:  15, 17, 25, 23, 20, 34, 40, 36, 30

    // 前序:  57, 60, 63, 67, 77, 78, 79, 80, 81
    // 后序:  57, 67, 63, 60, 78, 79, 81, 80, 77



    public static TreeNode rebuild(Map<Integer, Integer> index,
                                   int[] inOrders, int inBegin, int inEnd,
                                   int[] postOrders, int postBegin, int postEnd) {
        int rootVal = postOrders[postEnd];
        int rootIndex = index.get(rootVal);
        TreeNode root = new TreeNode(inOrders[rootIndex]);

        root.left = rebuild(index,
                inOrders, inBegin, rootIndex - 1,
                postOrders, postBegin, rootIndex - 1);
        root.right = rebuild(index,
                inOrders, rootIndex + 1, inEnd,
                postOrders, rootIndex, postEnd - 1);
        return root;
    }

}
