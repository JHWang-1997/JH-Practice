package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/27 20:59
 */
public class LC79 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Solution79 solution79 = new Solution79();
        boolean abcb = solution79.exist(board, "ABCB");
        System.out.println(abcb);
    }

}

class Solution79 {

    boolean[][] visited;

    int row, col;

    int[][] dire = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        // 先找到所有可能的起点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == chars[0]) {
                    visited[i][j] = true;
                    if (helper(board, chars, 0, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] chars, int idx, int r, int c) {
        if (idx == chars.length - 1 && board[r][c] == chars[idx]) {
            return true;
        }
        // 深度优先遍历
        for (final int[] ints : dire) {
            int r1 = r + ints[0];
            int c1 = c + ints[1];
            if (r1 < 0 || r1 >= row || c1 < 0 || c1 >= col || visited[r1][c1]) {
                continue;
            }
            // 标识已经访问
            visited[r1][c1] = true;
            if (board[r1][c1] == chars[idx + 1] && helper(board, chars, idx + 1, r1, c1)) {
                return true;
            }
            visited[r1][c1] = false;
        }
        return false;
    }
}