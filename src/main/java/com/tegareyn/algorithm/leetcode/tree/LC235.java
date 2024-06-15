package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 注意：
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中
 *
 * @author mocheng
 * @version 1.0
 * @see LC235
 * @since 2024/2/4 11:11
 **/
public class LC235 {

    public static void main(String[] args) {
        LC235 lt = new LC235();
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{0,-1000000000,1000000000});
        System.out.println(lt.lowestCommonAncestor2(root, new TreeNode(-1000000000), new TreeNode(1000000000)));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParent = new ArrayList<>();
        findParent(root, p, pParent);
        List<TreeNode> qParent = new ArrayList<>();
        findParent(root, q, qParent);
        int step = Math.min(qParent.size(), pParent.size());
        TreeNode result = null;
        for (int i = 0; i < step; i++) {
            TreeNode left = qParent.get(i);
            TreeNode right = pParent.get(i);
            if (left == right) {
                result = left;
            } else {
                break;
            }
        }
        return result;
    }

    public void findParent(TreeNode root, TreeNode p, List<TreeNode> parent) {
        if (root == null) {
            parent.clear();
            return;
        }
        parent.add(root);
        if (root.val > p.val) {
            findParent(root.left, p, parent);
        } else if (root.val < p.val) {
            findParent(root.right, p, parent);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(((long)(root.val - p.val) * (root.val - q.val)) > 0) { // 同为正负判断：差值乘积为正即可
            root = root.val > p.val ? root.left : root.right;
        }
        if (findParent(root, p) != null && findParent(root, q) != null) {
            return root;
        }
        return null;
    }

    public TreeNode findParent(TreeNode root, TreeNode p) {
        if (root == null || root.val == p.val) {
            return root;
        }
        return findParent(root.val > p.val ? root.left : root.right, p);
    }

}
