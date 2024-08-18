package leetcode;

/**
 * 191. 位1的个数
 *
 *@author JH-Wang
 *@since 2024/8/18 17:24
 */
public class LC191 {
}

class Solution191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}
