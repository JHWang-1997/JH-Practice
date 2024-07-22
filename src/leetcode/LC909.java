package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 *@author JH-Wang
 *@since 2024/7/22 23:22
 */
public class LC909 {
    public static void main(String[] args) {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1,
                -1, 13, -1}, {-1, -1, -1, -1
                , -1, -1}, {-1, 15, -1, -1, -1, -1}};
        Solution909 solution909 = new Solution909();
        int i = solution909.snakesAndLadders(board);
        System.out.println(i);
    }
}

class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        List<Integer> list = new ArrayList<>(n * n + 1);
        boolean[] done = new boolean[1 + n * n];
        int count = 1;
        list.add(0);
        int k = 0;
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                list.add(board[i][k] != -1 ? board[i][k] : count);
                k += (flag ? 1 : -1);
                count++;
            }
            flag = !flag;
            k += (flag ? 1 : -1);
        }
        count = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int t = 1; t <= 6; t++) {
                    // 下一跳有可能的六个位置
                    if (list.get(poll + t) == n * n) {
                        return count;
                    }
                    if (!done[poll + t]) {
                        // 已经到过的位置就不必再来了
                        queue.offer(list.get(poll + t));
                        done[poll + t] = true;
                    }
                }

            }
            count++;
        }
        // 无法到达
        return -1;
    }
}