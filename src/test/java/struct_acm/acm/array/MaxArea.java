package struct_acm.acm.array;

/**
 * 乘最多水的容器
 * 解题思路：双指针
 */
public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    private static int maxArea(int[] arr){
        int left = 0,right = arr.length-1;
        int ans = 0;
        while (left<right){
            int areas = Math.min(arr[left],arr[right]) * (right-left);
            ans = Math.max(ans,areas);
            if(arr[left]<=arr[right]){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
