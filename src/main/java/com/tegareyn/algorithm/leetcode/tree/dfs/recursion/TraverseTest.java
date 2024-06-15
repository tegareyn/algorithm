package com.tegareyn.algorithm.leetcode.tree.dfs.recursion;

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
        Integer[] array = new Integer[]{5,2,7,1,4,6,8};
        TreeNode root = TreeUtil.buildBinaryTree(array);

        System.out.println("前序遍历(中左右)： " + new PreOrderTraverse().orderTraversal(root));

        System.out.println("中序遍历(左中右)： " + new InOrderTraverse().orderTraversal(root));

        System.out.println("后序遍历(左右中)： " + new PostOrderTraverse().orderTraversal(root));
    }
}
