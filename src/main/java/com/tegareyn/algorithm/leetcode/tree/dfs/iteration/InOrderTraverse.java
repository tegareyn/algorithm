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
public class InOrderTraverse extends Traverse {

    @Override
    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右   注意：空节点不入栈
    public void traversal(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
    }

}
