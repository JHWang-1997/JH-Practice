package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/30 22:26
 */
public class LC53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = solution53.maxSubArray(arr);
        System.out.println(i);
    }
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int res = -10_000;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            res = Math.max(res, sum);
            if (sum < 0) {
                // 之前的和小于0，就从下一个值开始
                sum = 0;
            }
        }
        return res;
    }
}