package struct_acm.acm.array;

import java.util.Arrays;

/**
 *在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int[] ints = searchRange(nums, 2);
        Arrays.stream(ints).forEach(System.out::println);
    }

    /**
     * 自己实现版本
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        if (left == right) {
            if (target == nums[left]) return new int[]{left, left};
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                int firstIndex = mid;
                while (firstIndex-1 >=0 && target == nums[firstIndex-1]) {
                    firstIndex--;
                }
                int lastIndex = mid;
                while (lastIndex+1 < nums.length && target == nums[lastIndex+1]) {
                    lastIndex++;
                }

                return new int[]{firstIndex, lastIndex};
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};

    }
}
