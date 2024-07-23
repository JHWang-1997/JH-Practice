package leetcode;

import java.util.*;

/**
 *
 *@author JH-Wang
 *@since 2024/7/23 23:57
 */
public class LC433 {
}

class Solution433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int count = 0;
        if (Objects.equals(startGene, endGene)) {
            return count;
        }
        Set<String> done = new HashSet<>();
        done.add(startGene);
        Deque<String> queue = new LinkedList<>();
        queue.offer(startGene);
        count++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (final String s : bank) {
                    if (!done.contains(s) && diff(str, s) == 1) {
                        if (s.equals(endGene)) {
                            return count;
                        }
                        queue.offer(s);
                        done.add(s);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private int diff(String str1, String str2) {
        int len = str1.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}