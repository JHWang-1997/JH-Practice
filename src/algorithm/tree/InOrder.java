package algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 *@author JH-Wang
 *@since 2024/7/31 0:03
 */
public class InOrder {

    /**
     * 中序遍历非递归版
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    /**
     * 中序遍历递归版
     */
    public List<Integer> inOrderRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doInOrderRecursion(root, list);
        return list;
    }

    private void doInOrderRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        doInOrderRecursion(root.left, list);
        list.add(root.val);
        doInOrderRecursion(root.right, list);
    }
}
