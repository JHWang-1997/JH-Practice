package algorithm.tree;

/**
 *
 *@author JH-Wang
 *@since 2024/7/22 0:13
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public   TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
