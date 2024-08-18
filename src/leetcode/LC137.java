package leetcode;

/**
 * 137. 只出现一次的数字 II
 *
 *@author JH-Wang
 *@since 2024/8/18 17:32
 */
public class LC137 {

    public static void main(String[] args) {
        Solution137 solution137 = new Solution137();
        int i = solution137.singleNumber(new int[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 2});
        System.out.println(i);
    }
}

class Solution137 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int n : nums) {
            for (int i = 31; i >= 0; i--) {
                bits[i] += (n & 1);
                n >>= 1;
            }
        }
        int res = 0;
        for (final int bit : bits) {
            res <<= 1;
            res |= (bit % 3);
        }
        return res;
    }
}