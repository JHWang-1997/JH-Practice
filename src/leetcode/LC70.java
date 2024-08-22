package leetcode;

/**
 * 70. 爬楼梯
 *
 *@author JH-Wang
 *@since 2024/8/22 23:44
 */
public class LC70 {
}

class Solution70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int i = 1;
        int j = 2;
        int res = 3;
        for (int k = 3; k <= n; k++) {
            res = i + j;
            i = j;
            j = res;
        }
        return res;
    }
}