package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/25 23:15
 */
public class LC77 {
}

class Solution77 {


    List<List<Integer>> res = new ArrayList<>();

    boolean[] done;

    int n;

    public List<List<Integer>> combine(int n, int k) {
        done = new boolean[n + 1];
        this.n = n;
        doHelp(new ArrayList<>(), k);
        return res;
    }

    private void doHelp(List<Integer> list, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= n && !done[i]; i++) {
            list.add(i);
            done[i] = true;
            doHelp(list, k - 1);
            list.remove(list.size() - 1);
            done[i] = false;
        }
    }
}
