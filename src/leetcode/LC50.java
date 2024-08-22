package leetcode;

/**
 * 50. Pow(x, n)
 *
 *@author JH-Wang
 *@since 2024/8/21 23:50
 */
public class LC50 {
}

class Solution50 {
    public double myPow(double x, int n) {
        boolean flag = n < 0;
        double t = pow(x, n);
        return flag ? 1 / t : t;
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double y = pow(x, n / 2);
        return y * y * pow(x, n & 1);
    }
}
