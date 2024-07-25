package algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序 NlogN
 *
 *@author JH-Wang
 *@since 2024/7/25 23:35
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {0, -2, 4, 4, 5, 67, 76, 7, -100, 78, 43, 234, 4, 543, -5, -10};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        // 每次缩减一半
        for (int n = len / 2; n > 0; n /= 2) {
            for (int i = n; i < len; i++) {
                // 里面就是实现一个插入排序
                insertSort(arr, i, n);
            }
        }
    }

    // i表示起始元素，n代表间隔
    private static void insertSort(int[] arr, int i, int n) {
        int tem = arr[i];
        // 下一个元素跟本元素比
        while (i - n >= 0 && arr[i - n] > tem) {
            arr[i] = arr[i - n];
            i -= n;
        }
        arr[i] = tem;
    }

}
