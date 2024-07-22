package algorithm.sort;

import java.util.Arrays;

/**
 *
 *@author JH-Wang
 *@since 2024/7/23 0:13
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {0, -2, 4, 4, 5, 67, 76, 7,-100, 78, 43, 234, 4, 543, -5, -10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int tem = arr[i];
            int k = i;
            while (k >= 1 && arr[k - 1] > tem) {
                arr[k] = arr[k - 1];
                k--;
            }
            arr[k] = tem;
        }
    }
}


