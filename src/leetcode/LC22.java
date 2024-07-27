package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/27 20:43
 */
public class LC22 {

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(3);
        System.out.println(strings);
    }
}

class Solution22 {

    int n;
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        doHelp(new StringBuilder(), 0, 0);
        return res;
    }

    private void doHelp(StringBuilder sb, int l, int r) {
        if (l == n && l == r) {
            res.add(sb.toString());
        }
        if (l < n) {
            sb.append("(");
            doHelp(sb, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l > r) {
            sb.append(")");
            doHelp(sb, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
