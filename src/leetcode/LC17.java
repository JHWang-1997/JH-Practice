package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/25 22:52
 */
public class LC17 {
}

class Solution17 {

    List<String> list = new ArrayList<>(10);
    List<String> res = new ArrayList<>();

    {
        list.add("");
        list.add("");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("kjl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        doHelp(digits, 0, new StringBuilder());
        return res;
    }

    private void doHelp(String digit, int idx, StringBuilder sb) {
        if (digit.length() == idx) {
            res.add(sb.toString());
            return;
        }
        int n = digit.charAt(idx) - '0';
        String str = list.get(n);
        for (final char ch : str.toCharArray()) {
            sb.append(ch);
            doHelp(digit, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
