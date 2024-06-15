package com.tegareyn.algorithm.leetcode.tree.dfs;

import com.tegareyn.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 11:39
 **/
public abstract class Traverse {

    public List<Integer> orderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    /**
     * 树元素遍历
     *
     * @param root 树
     * @param result 遍历结果
     */
    public abstract void traversal(TreeNode root, List<Integer> result);

}
