package leetcode;

/**
 * 136. 只出现一次的数字
 *
 *@author JH-Wang
 *@since 2024/8/18 17:26
 */
public class LC136 {
}

class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (final int num : nums) {
            res ^= num;
        }
        return res;
    }
}
