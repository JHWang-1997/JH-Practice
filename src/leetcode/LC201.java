package leetcode;

/**
 * 201. 数字范围按位与
 *
 *@author JH-Wang
 *@since 2024/8/19 23:14
 */
public class LC201 {


}

class Solution201 {

    // 从left到right变化的过程，都是从低位到高位累加的
    // 所以低位一直在变化，肯定会有0，只需统计从高位开始的相同部分
    public int rangeBitwiseAnd(int left, int right) {
        int t = 1 << 30;
        int res = 0;
        while (t > 0 && (left & t) == (right & t)) {
            res |= (left & t);
            t >>= 1;
        }
        return res;
    }
}
