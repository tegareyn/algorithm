package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 描述：二叉搜索树的众数
 *
 * @author mocheng
 * @version 1.0
 * @see LC501
 * @since 2024/1/3 10:40
 **/
public class LC501 {

    Integer pre = null;
    Integer cur = null;
    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{26,2,8,0,4,7,9,null,null,2,6});
        LC501 lt501 = new LC501();
        System.out.println(Arrays.toString(lt501.findMode(root)));
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> result = new HashMap<>();
        resolve(root, result);
        if (cur != null && !cur.equals(pre)) {
            removeIfNeeded(result);
        }
        int[] r = new int[result.size()];
        Set<Integer> set = result.keySet();
        int i = 0;
        for (Integer num : set) {
            r[i++] = num;
        }
        return r;
    }

    public void resolve(TreeNode root, Map<Integer, Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            resolve(root.left, result);
        }
        int val = root.val;
        if (cur == null) {
            pre = val;
            cur = val;
        }
        if (val != cur) {
            removeIfNeeded(result);
            pre = cur;
            cur = val;
        }
        result.put(cur, 1 + (result.get(cur) != null ? result.get(cur) : 0));
        if (root.right != null) {
            resolve(root.right, result);
        }
    }

    private void removeIfNeeded(Map<Integer, Integer> result) {
        if (result.get(cur) > result.get(pre)) {
            Integer count = result.get(cur);
            result.clear();
            result.put(cur, count);
            pre = cur;
        } else if (result.get(cur) < result.get(pre)) {
            result.remove(cur);
            cur = pre;
        }
    }
}
