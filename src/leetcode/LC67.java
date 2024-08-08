package leetcode;

/**
 * 67. 二进制求和
 *
 *@author JH-Wang
 *@since 2024/8/8 23:47
 */
public class LC67 {

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        String s = solution67.addBinary("1010", "1011");
        System.out.println(s);
    }
}

class Solution67 {
    public String addBinary(String a, String b) {
        char[] ar = a.toCharArray();
        char[] br = b.toCharArray();
        revert(ar);
        revert(br);
        int i = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i < ar.length || i < br.length) {
            int t1 = i < ar.length ? ar[i] - '0' : 0;
            int t2 = i < br.length ? br[i] - '0' : 0;
            sb.append((t1 + t2 + carry) % 2);
            carry = (t1 + t2 + carry) / 2;
            i++;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private void revert(char[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            char tem = arr[l];
            arr[l] = arr[r];
            arr[r] = tem;
            l++;
            r--;
        }
    }
}
