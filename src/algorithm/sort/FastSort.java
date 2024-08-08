package algorithm.sort;

import java.util.Arrays;

/**
 *
 *@author JH-Wang
 *@since 2024/8/6 23:34
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = {0, -2, 4, 4, 5, 67, 0, 999, -999, 76, 7, -100, 78, 43, 234, 4, 543, -5, -10};
        fastSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void fastSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        doSort(0, nums.length - 1, nums);
    }

    private static void doSort(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }
        int mid = help(left, right, nums);
        doSort(0, mid - 1, nums);
        doSort(mid + 1, right, nums);
    }

    private static int help(int left, int right, int[] nums) {
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            int tem = nums[l];
            nums[l] = nums[r];
            nums[r] = tem;
        }
        nums[left] = nums[l];
        nums[l] = pivot;
        return l;
    }

}


