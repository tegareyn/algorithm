package com.tegareyn.algorithm.leetcode.tree.dfs.recursion;

import com.tegareyn.algorithm.leetcode.tree.dfs.Traverse;
import com.tegareyn.algorithm.model.TreeNode;

import java.util.List;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 11:34
 **/
public class PreOrderTraverse extends Traverse {

    @Override
    public void traversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }
}
