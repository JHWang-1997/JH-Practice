package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/30 22:34
 */
public class LC918 {

    public static void main(String[] args) {
        Solution918 solution918 = new Solution918();
        int[] arr = {5, -3, 5};
        int i = solution918.maxSubarraySumCircular(arr);
        System.out.println(i);
    }
}

class Solution918 {

    public int maxSubarraySumCircular(int[] nums) {
        int dp = nums[0];
        int sum = dp;
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            // 计算连续和最大的子数组
            sum += nums[i];
            dp = nums[i] + Math.max(0, dp);
            max = Math.max(dp, max);
        }
        dp = nums[0];
        int min = 0;
        // 不取最后一个，因为最后一个如果是负数，肯定不会被统计到max中
        for (int i = 1; i < nums.length - 1; i++) {
            // 计算数组中间连续和最小的子数组
            dp = nums[i] + Math.min(0, dp);
            min = Math.min(dp, min);
        }
        return Math.max(sum - min, max);
    }
}
