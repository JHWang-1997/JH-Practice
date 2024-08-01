package leetcode;

import java.util.Arrays;

/**
 *
 *@author JH-Wang
 *@since 2024/8/1 23:47
 */
public class LC34 {

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = solution34.searchRange(nums, 6);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length < 1) {
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        // 先找最左边的
        while (l < r) {
            int mid = (l + r) / 2;
            if (target <= nums[mid]) {
                // 保留相等的值，向左靠
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return res;
        }
        res[0] = l;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                // 保留相等的值，向右靠
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        res[1] = r;
        return res;
    }
}