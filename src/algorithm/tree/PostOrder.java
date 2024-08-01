package algorithm.tree;

import java.util.*;

/**
 *
 *@author JH-Wang
 *@since 2024/7/31 23:33
 */
public class PostOrder {

    // 非递归版
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postOrderRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        doHelp(root, list);
        return list;
    }

    private void doHelp(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        doHelp(root.left, list);
        doHelp(root.right, list);
        list.add(root.val);
    }
}
