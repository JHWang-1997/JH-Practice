package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序 N*N
 *
 *@author JH-Wang
 *@since 2024/7/22 0:02
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {324, 4, 54, 6, -1, -34, 87, 46, 234, 23, 56, 675, 658, 76, 232};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tem = arr[min];
            arr[min] = arr[i];
            arr[i] = tem;
        }
    }
}
