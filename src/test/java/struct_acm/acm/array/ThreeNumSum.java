package struct_acm.acm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 思路
 * 外层循环：指针 i 遍历数组。
 * 内层循环：用双指针，去寻找满足三数之和 == 0 的元素
 *
 * 先排序的意义
 * 便于跳过重复元素，如果当前元素和前一个元素相同，跳过。
 *
 * 双指针的移动时，避免出现重复解
 * 找到一个解后，左右指针同时向内收缩，为了避免指向重复的元素，需要：
 *
 * 左指针在保证left < right的前提下，一直右移，直到指向不重复的元素
 * 右指针在保证left < right的前提下，一直左移，直到指向不重复的元素
 * 小优化
 * 排序后，如果外层遍历的数已经大于0，则另外两个数一定大于0，sum不会等于0，直接break。
 */
public class ThreeNumSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println("aaa");
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        //如果数组为空 或者 数组长度小于3，则不可能组成三数之和，直接返回null
        if(nums == null || nums.length < 3) return new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //因为在正序数组中，如果当前元素大于0的话，就不可能与后续元素相加为0，所以跳出循环
            if(nums[i] > 0) break;
            //去重：nums[i]为双指针找寻的基准数，如果基准数一致，则会导致结果一致
            //又因为是排序好的正序数组，所以比较前一个元素就能判断当前nums[i]是否已经找过
            if(i>0 && nums[i] == nums[i-1]) continue;
            int L = i+1;
            int R = len-1;

            //利用双指针去找寻 三数之和
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //去重：双指针找寻过程中，有可能存在L与后一位元素 || R与前一位元素相同的情况
                    //因为基准数在  while (L<R) 循环体里是固定的，如果两次L都是同一个数，那么找寻和为0的R一定也和之前找寻过的结果一样
                    while (L<R && nums[L] == nums[L+1]) L++;
                    while (L<R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }else if (sum<0) L++;
                else R--;
            }
        }
        return result;
    }
}
