package algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/31 23:33
 */
public class PostOrder {

    // 非递归版
    public List<Integer> postOrder(TreeNode root) {
        // TODO
        return null;
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
