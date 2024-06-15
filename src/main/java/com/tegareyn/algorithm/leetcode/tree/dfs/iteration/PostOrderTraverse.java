package com.tegareyn.algorithm.leetcode.tree.dfs.iteration;

import com.tegareyn.algorithm.leetcode.tree.dfs.Traverse;
import com.tegareyn.algorithm.model.TreeNode;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 11:34
 **/
public class PostOrderTraverse extends Traverse {

    @Override
    // 后序遍历 遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    public void traversal(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
    }
}
