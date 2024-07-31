package leetcode;

/**
 * 二分查找
 *
 *@author JH-Wang
 *@since 2024/7/31 22:32
 */
public class LC35 {
}

class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
