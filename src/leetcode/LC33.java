package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/8/1 23:26
 */
public class LC33 {

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = {3, 1};
        int search = solution33.search(nums, 1);
        System.out.println(search);
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[l]) {
                // 包括mid在内左边是有序的
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                // mid右边是有序的
                if (target >= nums[mid+1] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}