package algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/22 0:11
 */
public class PreOrder {

    /**
     * 非递归
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                if (root.right != null) {
                    // 右节点入栈
                    stack.push(root.right);
                }
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return res;
    }

    /**
     * 递归版
     */
    public List<Integer> preOrderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doPreOrder(root, res);
        return res;
    }

    private void doPreOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        doPreOrder(node.left, list);
        doPreOrder(node.right, list);
    }

}
