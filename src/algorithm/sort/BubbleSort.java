package algorithm.sort;

import java.util.Arrays;

/**
 *
 *@author JH-Wang
 *@since 2024/7/24 0:15
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {324, 4, 54, 6, -1, -34, 87, 46, 234, 23, 56, 675, 658, 76, 232, 456, 567, 678, 789, 890, 1000};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 1; j < len - i; j++) {
                if (arr[j] < arr[j - 1]) { // 相等不交换，稳定排序
                    // 交换位置
                    int tem = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tem;
                    flag = true; // 发生交换
                }
            }
            if (!flag) {
                // 此轮没有发生交换，后面已经是有序的了
                break;
            }
        }
    }

}
