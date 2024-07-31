package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/31 23:07
 */
public class LC162 {

}

class Solution162 {

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid - 1] < nums[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}