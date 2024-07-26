package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/26 23:00
 */
public class LC39 {

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] candidates = {1, 2, 3, 6, 7};
        List<List<Integer>> lists = solution39.combinationSum(candidates, 7);
        System.out.println(lists);
    }
}

class Solution39 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        doHelp(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void doHelp(int[] candidates, int target, int idx, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            // 允许当前位置的元素再次参与计算
            doHelp(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}