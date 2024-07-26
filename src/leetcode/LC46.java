package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/26 22:45
 */
public class LC46 {
}

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    // 标识元素是否被遍历
    boolean[] visited;

    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        this.nums = nums;
        doHelp(new ArrayList<>());
        return res;
    }

    private void doHelp(List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            doHelp(list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
