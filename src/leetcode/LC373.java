package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的 K 对数字
 *
 *@author JH-Wang
 *@since 2024/8/6 22:47
 */
public class LC373 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        int[] arr2 = {1, 2, 3};
        Solution373 solution373 = new Solution373();
        List<List<Integer>> lists = solution373.kSmallestPairs(arr1, arr2, 2);
        System.out.println(lists);
    }
}

class Solution373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue =
                new PriorityQueue<>((arr1, arr2) -> nums1[arr1[0]] + nums2[arr1[1]] - nums1[arr2[0]] - nums2[arr2[1]]);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            queue.offer(new int[]{i, 0});
        }
        while (k > 0 && !queue.isEmpty()) {
            int[] idx = queue.poll();
            res.add(Arrays.asList(nums1[idx[0]], nums2[idx[1]]));
            if (idx[1] + 1 < nums2.length) {
                queue.offer(new int[]{idx[0], idx[1] + 1});
            }
            k--;
        }
        return res;
    }
}


