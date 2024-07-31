package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/31 22:40
 */
public class LC75 {
}

class Solution75 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }
        int up = 0;
        int bo = matrix.length - 1;
        while (up < bo) {
            int mid = (up + bo + 1) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                up = mid;
            } else {
                bo = mid - 1;
            }
        }
        int l = 0;
        int r = col - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (matrix[up][mid] == target) {
                return true;
            }
            if (matrix[up][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return matrix[up][l] == target;
    }
}