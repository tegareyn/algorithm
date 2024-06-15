package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;

/**
 * 描述：最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树
 *
 * @author mocheng
 * @version 1.0
 * @see LC654
 * @since 2023/12/19 18:44
 **/
public class LC654 {

    public static TreeNode solution(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public static TreeNode build(int[]nums, int left, int right) {
        if (right - left < 1) {
            return null;
        } else if (right - left == 1) {
            return new TreeNode(nums[left]);
        } else {
            int maxIndex = left;
            int max = nums[maxIndex];
            for (int i = left + 1; i < right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            TreeNode node = new TreeNode(max);
            node.left = build(nums, left, maxIndex);
            node.right = build(nums, maxIndex + 1, right);
            return node;
        }
    }

}
