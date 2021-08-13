package struct_acm.acm.array;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * 输入：nums1 = [2,4,5], nums2 = [1,3]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3,4,5] ，中位数 3
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,3], nums2 = [2,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class SearchMidNum {
    public static void main(String[] args) {
        System.out.println(solve2(new int[]{1, 2}, new int[]{3, 4}));
    }

    /**
     * 合并数组后返回中位数
     * @param num1
     * @param num2
     * @return
     */
    private static double solve1(int[] num1,int[] num2){
        int aLen = num1.length;
        int bLen = num2.length;

        if(aLen == 0){
            if(bLen % 2 == 0){
              return (num2[bLen/2-1]+num2[bLen/2])/2.0;
            }else {
              return num2[bLen/2];
            }
        }

        if(bLen == 0){
            if(aLen % 2 == 0){
                return (num1[aLen/2-1]+num1[aLen/2])/2.0;
            }else {
                return num1[aLen/2];
            }
        }

        int aStart = 0,bStart=0;
        int count = 0;
        int[] unionNums = new int[aLen+bLen];
        while (count != (aLen+bLen)){
            if(aStart == aLen){
               while (bStart != bLen){
                   unionNums[count++] = num2[bStart++];
               }
               break;
            }
            if(bStart == bLen){
                while (aStart != aLen){
                    unionNums[count++] = num1[aStart++];
                }
                break;
            }

            if(num1[aStart] < num2[bStart]){
                unionNums[count++] = num1[aStart++];
            }else {
                unionNums[count++] = num2[bStart++];
            }
        }

        if(count %2 == 0){
            return (unionNums[count/2-1]+unionNums[count/2])/2.0;
        }else {
            return unionNums[count/2];
        }

    }

    /**
     * 直接找中位数
     * @param nums1
     * @param nums2
     * @return
     */
    private static double solve2(int[] nums1,int[] nums2){
        int aLen = nums1.length;
        int bLen = nums2.length;
        int len = aLen+bLen;

        int left = -1,right=-1;
        int aStart = 0,bStart = 0;
        for (int i=0;i<=len/2;i++){
            left = right;
            if(aStart<aLen && (bStart>=bLen || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }

        if(len % 2 == 0){
            return (left+right)/2.0;
        }else {
            return right;
        }
    }

}
