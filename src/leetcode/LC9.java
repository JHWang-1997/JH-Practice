package leetcode;

/**
 * 9. 回文数
 *
 *@author JH-Wang
 *@since 2024/8/19 23:23
 */
public class LC9 {

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(1874994781));
    }
}

class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        long left = 10;
        long right = 10;
        while (left * 10 < x) {
            left *= 10;
        }
        while (left >= right) {
            if (x / left != x % right) {
                return false;
            }
            x = (int) (x % left);
            left /= 100;
            x = x / 10;
        }
        return true;
    }
}
