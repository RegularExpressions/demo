package struct_acm.acm.array;

/**
 * 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，使数组变为
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class SearchCircleSortArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1};//4,5,6,7,0,1,2
        System.out.println(search(nums, 1));
    }

    /**
     * 思路，二分查找变种
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        //考虑数组为空的情况
      if(nums == null || nums.length ==0) return -1;

      int left = 0,right = nums.length-1;
      //考虑数组长度为1的情况
      if(right == 0){
         if(nums[0] == target) return 0;
         return -1;
      }

      while (left<=right){
          int mid = (left+right)/2;

          if(nums[mid] == target) return mid;

          if(nums[left] <= nums[mid]){
             if(target >= nums[left] && target < nums[mid]){
                 right = mid-1;
             }else {
                 left = mid+1;
             }
          }else {
             if(target> nums[mid] && target <= nums[right]){
                 left = mid+1;
             }else {
                 right = mid-1;
             }
          }
      }
      return -1;
    }


}
