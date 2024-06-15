package com.tegareyn.algorithm.model;

/**
 * @ClassName Node
 * @Description leetcode 特殊二叉树
 * @Author mocheng
 * @Since 2022/11/28 00:09
 * @Version 1.0
 **/
public class SpecialTree {
    public int val;
    public SpecialTree left;
    public SpecialTree right;
    public SpecialTree next;

    public SpecialTree() {}

    public SpecialTree(int _val) {
        val = _val;
    }

    public SpecialTree(int _val, SpecialTree _left, SpecialTree _right, SpecialTree _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
