package leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 *@author JH-Wang
 *@since 2024/8/5 23:59
 */
public class LC153 {

    public static void main(String[] args) {
        Solution153 solution53 = new Solution153();
        int[] nums = {11,13,15,17,1};
        int min = solution53.findMin(nums);
        System.out.println(min);
    }
}

class Solution153 {
    public int findMin(int[] nums) {
        // 二分法
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                // 左边是有序的
                if (nums[l] < nums[r]) {
                    return nums[l];
                } else {
                    l = mid + 1;
                }
            } else {
                // 最小值在mid的左边（也可能是mid）
                r = mid;
            }
        }
        return nums[l];
    }
}
