package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * @author mocheng
 * @version 1.0
 * @see LC538
 * @since 2024/2/17 11:32
 **/
public class LC538 {

    private int sum = 0;
    public static void main(String[] args) {
        final TreeNode node = TreeUtil.buildBinaryTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        LC538 lc538 = new LC538();
        System.out.println(lc538.convertBST(node));
        lc538.convertBST1(node);
        System.out.println(node);
    }

    public void convertBST1(TreeNode root) {
        if (root != null) {
            convertBST1(root.right);
            root.val += sum;
            sum = root.val;
            convertBST1(root.left);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Map<Integer, Integer> treeNodeIndexMap = new HashMap<>();
        inOrder(treeNodeIndexMap, order, root);
        final int[] rebuildSumList = rebuildSumList(order);
        return rebuildTree(root, treeNodeIndexMap, rebuildSumList);
    }

    public void inOrder(Map<Integer, Integer> treeNodeIndexMap, List<Integer> inOrderList, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(treeNodeIndexMap, inOrderList, root.left);
        }
        inOrderList.add(root.val);
        treeNodeIndexMap.put(root.val, inOrderList.size() - 1);
        if (root.right != null) {
            inOrder(treeNodeIndexMap, inOrderList, root.right);
        }
    }

    public int[] rebuildSumList(List<Integer> inOrderList){
        int[] rebuild = new int[inOrderList.size()];
        int sum = 0;
        for (int i = inOrderList.size() - 1; i >= 0; i--) {
            rebuild[i] = sum + inOrderList.get(i);
            sum = rebuild[i];
        }
        return rebuild;
    }
    public TreeNode rebuildTree(TreeNode root, Map<Integer, Integer> treeNodeIndexMap, int[] rebuildSumList) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(rebuildSumList[treeNodeIndexMap.get(root.val)]);
        if (root.left != null) {
            node.left = rebuildTree(root.left, treeNodeIndexMap, rebuildSumList);
        }
        if (root.right != null) {
            node.right = rebuildTree(root.right, treeNodeIndexMap, rebuildSumList);
        }
        return node;
    }

}
