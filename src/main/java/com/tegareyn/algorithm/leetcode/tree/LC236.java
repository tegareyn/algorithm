package com.tegareyn.algorithm.leetcode.tree;

import com.tegareyn.algorithm.model.TreeNode;
import com.tegareyn.algorithm.utils.TreeUtil;

import java.util.*;

/**
 * 描述：二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * 对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 *
 * @author mocheng
 * @version 1.0
 * @see LC236
 * @since 2024/2/1 15:54
 **/
public class LC236 {

    List<TreeNode> pParent = new ArrayList<>();
    List<TreeNode> qParent = new ArrayList<>();

    public static void main(String[] args) {
        LC236 lt = new LC236();
        TreeNode root = TreeUtil.buildBinaryTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        System.out.println(lt.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)));
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        findTargetParent(root, p, q, new ArrayList<>());
        for (int i = pParent.size() - 1; i >= 0; i--) {
            TreeNode node = pParent.get(i);
            if (qParent.contains(node)) {
                return node;
            }
        }
        return null;
    }

    /**
     *
     * 搜索过程中，使用了很多重复的额外空间
     *
     * @param root
     * @param p
     * @param q
     * @param list
     */
    private void findTargetParent(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        List<TreeNode> arrayList = new ArrayList<>(list);
        arrayList.add(root);
        if (pParent.size() == 0 || qParent.size() == 0) {
            if (root.val == q.val) {
                qParent = arrayList;
            }
            if (root.val == p.val) {
                pParent = arrayList;
            }
            findTargetParent(root.left, p, q, arrayList);
            findTargetParent(root.right, p, q, arrayList);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parent = new HashMap<>();
        buildParent(root, parent);
        // p 父节点链. 随机查询居多，所以用set
        Set<Integer> pParent = new HashSet<>();
        while (p != null) {
            pParent.add(p.val);
            p = parent.get(p.val);
        }
        // q 父节点校验链.
        while (q != null && pParent.size() > 0) {
            if (pParent.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     *
     * 通过map构造父节点搜索链
     * 会屏蔽叶子结点 ---- 因为不同节点的公共节点肯定不是叶子结点
     *
     * @param root
     * @param parent
     */
    public void buildParent(TreeNode root, Map<Integer, TreeNode> parent) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            buildParent(root.right, parent);
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
            buildParent(root.left, parent);
        }
    }

}
