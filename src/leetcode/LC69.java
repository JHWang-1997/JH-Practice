package leetcode;

/**
 * X的平方根
 *
 *@author JH-Wang
 *@since 2024/8/21 23:35
 */
public class LC69 {
}

class Solution69 {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (mid <= x / mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
