package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

/**
 * 描述：
 *
 * @author mocheng
 * @version 1.0
 * @see LC108
 * @since 2024/2/5 16:34
 **/
public class LC108 {

    public static void main(String[] args) {
        final TreeNode node = TreeUtil.buildBinaryTree(new Integer[]{});
        LC108 lc108 = new LC108();
        final TreeNode x = lc108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(x);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right || left < 0 || left > nums.length - 1 || right > nums.length - 1) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root  = new TreeNode(nums[mid]);
        root.right = build(nums, mid + 1, right);
        root.left = build(nums, left, mid - 1);
        return root;
    }


}
