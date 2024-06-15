package com.tegareyn.algorithm.leetcode.tree.dfs.iteration;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/9/12 11:00
 **/
public class TraverseTest {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{55, 30, 77, 20, 36, 60, 80, 17, 23, 34, 40, 57, 63, 79, 81, 15, null, null, 25, null, null, null, null, null, null, null, 67, 78, null, null, null};
        TreeNode root = TreeUtil.buildBinaryTree(array);

        System.out.println("前序遍历： " + new PreOrderTraverse().orderTraversal(root));

        System.out.println("中序遍历： " + new InOrderTraverse().orderTraversal(root));

        System.out.println("后序遍历： " + new PostOrderTraverse().orderTraversal(root));
    }
}
