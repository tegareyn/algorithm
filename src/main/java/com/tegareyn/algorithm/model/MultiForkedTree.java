package com.tegareyn.algorithm.model;

import java.util.List;

/**
 * 描述：多叉树
 *
 * @author mocheng
 * @version 1.0
 * @since 2023/8/29 16:47
 **/
public class MultiForkedTree {
    public int val;
    public List<MultiForkedTree> children;

    public MultiForkedTree() {}

    public MultiForkedTree(int val) {
        this.val = val;
    }

    public MultiForkedTree(int _val, List<MultiForkedTree> _children) {
        val = _val;
        children = _children;
    }

}
