package leetcode;

/**
 * 190. 颠倒二进制位
 *
 *@author JH-Wang
 *@since 2024/8/18 17:15
 */
public class LC190 {

    public static void main(String[] args) {
        Solution190 solution190 = new Solution190();
        System.out.println(solution190.reverseBits(-3));
    }
}

class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 32; i > 0; i--) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }
}
