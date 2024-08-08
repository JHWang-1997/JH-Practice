package algorithm.sort;

import java.util.Arrays;

/**
 *
 *@author JH-Wang
 *@since 2024/8/8 22:49
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0, -2, 4, 4, 5, 67, 0, 999, -999, 76, 7, -100, 78, 43, 234, 4, 543, -5, -10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        // 所有非叶子节点进行调整，构造一个大根堆
        for (int i = len / 2; i >= 0; i--) {
            adjust(nums, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            // 取大根堆的顶作为最大值，放到数组的最后
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }

    }

    // 下沉调整
    private static void adjust(int[] nums, int parent, int len) {
        int tem = nums[parent];
        while (parent < len) {
            int max = parent * 2 + 1;
            if (max >= len) {
                break;
            }
            if (max + 1 < len && nums[max + 1] > nums[max]) {
                max++;
            }
            if (nums[max] > tem) {
                nums[parent] = nums[max];
                parent = max;
            } else {
                break;
            }
        }
        nums[parent] = tem;
    }

    private static void swap(int[] nums, int n1, int n2) {
        int tem = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tem;
    }

}
