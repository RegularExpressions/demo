package struct_acm.acm.sort;

import java.util.Arrays;

/**
 * 选择排序思想
 * 第一次从 arr[0]~arr[n-1]中选取最小值， 与 arr[0]交换，
 * 第二次从 arr[1]~arr[n-1]中选取最小值，与 arr[1]交换，…，
 * 第 i 次从 arr[i-1]~arr[n-1]中选取最小值，与 arr[i-1]交换，…,
 * 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值， 与 arr[n-2]交换，
 * 总共通过 n-1 次，得到一个按排序码从小到大排列的有序序列
 * <p>
 * 原始数组：  101，34，119，1
 * 第一轮排序： 1(确定)，34，119，101
 * 第二轮排序： 1(确定)，34(确定)，119，101
 * 第三轮爬行： 1(确定)，34(确定)，101(确定)，119
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, -1, 10, 20};
        selectSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
