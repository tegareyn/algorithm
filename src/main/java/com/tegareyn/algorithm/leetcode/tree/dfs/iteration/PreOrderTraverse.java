package com.tegareyn.algorithm.leetcode.tree.dfs.iteration;

import com.tegareyn.algorithm.leetcode.tree.dfs.Traverse;
import com.tegareyn.algorithm.model.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 11:34
 **/
public class PreOrderTraverse extends Traverse {

    @Override
    // 前序遍历  遍历顺序：中-左-右，入栈顺序：中-右-左
    public void traversal(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
    }
}
