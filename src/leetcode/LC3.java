package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *@author JH-Wang
 *@since 2024/7/25 23:32
 */
public class LC3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int a = solution3.lengthOfLongestSubstring(
                "pwwkewpwhdfiuoshnfuiweyfnbsdncvosdiyurfoiwear 3iu4y892 " +
                        "yr9ddfh289ry9f7tgriwebkjdcnksdhf8943yt9fgiudsmlasdhweifcjkdsnckwehywkew");
        System.out.println(a);
    }
}


class Solution3 {

    /**
     * 双指针+集合
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (!set.contains(ch)) {
                set.add(ch);
                r++;
                continue;
            }
            res = Math.max(res, r - l);
            set.remove(s.charAt(l++));
        }
        return Math.max(res, r - l);
    }
}
