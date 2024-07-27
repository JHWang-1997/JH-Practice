package algorithm.sort;

import java.util.Arrays;

/**
 *
 *@author JH-Wang
 *@since 2024/7/27 21:52
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {0, -2, 4, 4, 5, 67, 0, 999, -999, 76, 7, -100, 78, 43, 234, 4, 543, -5, -10};
        int[] mergeSort = mergeSort(arr);
        System.out.println(Arrays.toString(mergeSort));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        return merge(mergeSort(Arrays.copyOfRange(arr, 0, mid)), mergeSort(Arrays.copyOfRange(arr, mid, arr.length)));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = len1 + len2;
        int[] arr = new int[len];
        int i1 = 0, i2 = 0;
        int idx = 0;
        while (i1 < len1 || i2 < len2) {
            int v1 = i1 < len1 ? arr1[i1] : Integer.MAX_VALUE;
            int v2 = i2 < len2 ? arr2[i2] : Integer.MAX_VALUE;
            if (v1 < v2) {
                arr[idx] = v1;
                i1++;
            } else {
                arr[idx] = v2;
                i2++;
            }
            idx++;
        }
        return arr;
    }

}
