package leetcode;

/**
 * 172. 阶乘后的零
 *
 *@author JH-Wang
 *@since 2024/8/21 23:21
 */
public class LC172 {
}

class Solution172 {

    public int trailingZeroes(int n) {
        return n / 5 + n / 25 + n / 125 + n / 625 + n / 625 / 5;
    }
}


