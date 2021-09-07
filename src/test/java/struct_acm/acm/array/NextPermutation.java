package struct_acm.acm.array;

import java.util.Arrays;

/**
 * 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int len = nums.length;

        int i = len - 2;
        int j = len - 1;
        int k = len - 1;

        //找到第一个升序元素对
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        //在[j,end)范围内找到第一个大于arr[i]的元素(arr[k])，并交换i和k
        if (i >= 0) {
            while (k >= j && nums[k] <= nums[i]) {
                k--;
            }
            swap(nums, i, k);
        }
        //将[j,end)范围内的数列变为升序数列
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
