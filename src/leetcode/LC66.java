package leetcode;

/**
 * 66. 加一
 *
 *@author JH-Wang
 *@since 2024/8/21 23:09
 */
public class LC66 {
}

class Solution66 {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int tem = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
            carry = tem;
        }
        if (carry > 0) {
            int[] res = new int[len + 1];
            System.arraycopy(digits, 0, res, 1, len);
            res[0] = carry;
            return res;
        }
        return digits;
    }
}