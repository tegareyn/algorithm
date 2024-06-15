package com.tegareyn.algorithm.leetcode.tree.bfs;

import com.tegareyn.algorithm.model.MultiForkedTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述： 叉树的层序遍历
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/30 10:11
 **/
public class LC429 {

    public static void main(String[] args) {

        List<MultiForkedTree> first7 = new ArrayList<>();
        first7.add(new MultiForkedTree(11));

        List<MultiForkedTree> first3 = new ArrayList<>();
        List<MultiForkedTree> first5 = new ArrayList<>();
        first3.add(new MultiForkedTree(6));
        first3.add(new MultiForkedTree(7, first7));
        first5.add(new MultiForkedTree(9));
        first5.add(new MultiForkedTree(10));

        List<MultiForkedTree> first1 = new ArrayList<>();
        first1.add(new MultiForkedTree(2));
        first1.add(new MultiForkedTree(3, first3));
        first1.add(new MultiForkedTree(4));
        first1.add(new MultiForkedTree(5, first5));

        MultiForkedTree root = new MultiForkedTree(1, first1);
        System.out.println(traversal(root));

    }


    public static List<List<Integer>> traversal(MultiForkedTree root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<MultiForkedTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> items = new ArrayList<>();
            while (size > 0) {
                MultiForkedTree tree = queue.poll();
                size--;
                if (tree == null) {
                    break;
                }
                items.add(tree.val);
                final List<MultiForkedTree> children = tree.children;
                if (children != null && children.size() > 0) {
                    queue.addAll(children);
                }
            }
            result.add(items);
        }
        return result;
    }

}
