package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 *@author JH-Wang
 *@since 2024/7/28 15:49
 */
public class LC108 {
}


class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 取中间元素作为root
        int len = nums.length;
        int mid = len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (len == 1) {
            return root;
        }
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, len));
        return root;
    }
}