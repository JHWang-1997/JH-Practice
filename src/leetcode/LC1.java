package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *@author JH-Wang
 *@since 2024/7/23 0:10
 */
public class LC1 {
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            // 先判断再放入，避免找到自己
            if (map.containsKey(c)) {
                return new int[]{i, map.get(c)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}