package struct_acm.acm.array;

import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class KminNum {

    public static void main(String[] args) {
        int k = 10;
        int[] arr = new int[]{0,0,2,3,2,1,1,2,0,4};
        solve3(arr,k-1);
        for (int i =0;i<k;i++){
            System.out.println(arr[i]);
        }
    }

    private static void solve1(int[] arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1,v2)->v2-v1);
        for (int i=0;i<k;i++){
            queue.offer(arr[i]);
        }

        for (int i =k;i<arr.length;i++){
            if(!queue.isEmpty() && queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i=0;i<k;i++){
            System.out.println(queue.poll());
        }
    }

    /**
     * 用这个估计会被鄙视至死
     * @param arr
     * @param k
     */
    private static void solve2(int[] arr,int k){
        quickSort(arr,0,arr.length-1);

        for (int i = 0;i<k;i++){
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr,int start,int end){
        if(start > end)
            return;

        int temp = arr[start];
        int i = start,j=end;

        while (i!=j){
            while (arr[j]>=temp && i<j) j--;
            while (arr[i]<=temp && i<j) i++;

            if(i<j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        arr[start] = arr[i];
        arr[i] = temp;

        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);

    }

    private static void solve3(int[] arr,int k){
        quickSearch(arr,0,arr.length-1,k);
    }

    private static void quickSearch(int[] arr,int start,int end,int k){
        int i = partSearch(arr,start,end);

        if(i==k){
        }else if(i<k){
            quickSearch(arr, i + 1, end, k);
        }else {
            quickSearch(arr, start, i - 1, k);
        }
    }

    private static int partSearch(int[] arr,int start,int end){
        if(start > end) return -1;

        int temp = arr[start];
        int i = start,j=end;

        while (i!=j){
            while (arr[j] >= temp && i<j) j--;
            while (arr[i] <= temp && i<j) i++;

            if(i<j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        arr[start] = arr[i];
        arr[i] = temp;

        return i;
    }
}
