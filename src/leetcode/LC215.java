package leetcode;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 *@author JH-Wang
 *@since 2024/8/6 22:13
 */
public class LC215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        Solution215 solution215 = new Solution215();
        int kthLargest = solution215.findKthLargest(nums, 1);
        System.out.println(kthLargest);
    }
}

class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compare);
        for (final int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
                continue;
            }
            if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.poll();
    }
}