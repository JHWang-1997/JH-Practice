package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/21 23:43
 */
public class LC210 {
}


class Solution210 {

    // 邻接表
    List<List<Integer>> list;

    // 无循环依赖的课程标识
    boolean[] okCource;

    int[] res;

    int count = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>(numCourses);
        okCource = new boolean[numCourses];
        res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (final int[] prerequisite : prerequisites) {
            list.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dsf(i, new boolean[numCourses])) {
                return new int[0];
            }
        }
        return res;
    }

    private boolean dsf(int idx, boolean[] noted) {
        if (noted[idx]) {
            // 该课程被循环依赖
            return false;
        }
        if (okCource[idx]) {
            // 以及处理过该课程
            return true;
        }
        noted[idx] = true;
        for (final Integer integer : list.get(idx)) {
            if (!dsf(integer, noted)) {
                return false;
            }
        }
        // 走到这说明这门课依赖的所有课都已经排完了
        res[count++] = idx;
        okCource[idx] = true;
        noted[idx] = false;
        return true;
    }
}