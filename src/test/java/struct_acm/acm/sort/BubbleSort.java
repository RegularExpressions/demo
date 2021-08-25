package struct_acm.acm.sort;

import java.util.Arrays;

/**
 * 冒泡排序 //如果相邻的元素逆序就交换（+号表示指针）
 *
 * 原始数组：3，9，-1，10，20
 * 第一趟排序：
 * +  +
 * 3，9，-1，10，20
 *    +  +
 * 3，-1，9，10，20
 *        +  +
 * 3，-1，9，10，20
 *           +  +
 * 3，-1，9，10，20（确定）
 * 第二趟排序：
 *  +  +
 * -1，3，9，10，20（确定）
 *     +  +
 * -1，3，9，10，20（确定）
 *        +  +
 * -1，3，9，10(确定)，20（确定）
 * 第三趟排序：
 *  +  +
 * -1，3，9，10(确定)，20(确定)
 *     +  +
 * -1，3，9(确定)，10(确定)，20(确定)
 * 第四趟排序：
 *  +  +
 * -1，3(确定)，9(确定)，10(确定)，20(确定)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,9,-1,10,20};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void bubbleSort(int[] arr){
      for (int i=0;i<arr.length-1;i++){
          boolean flag = false;
          for(int j=0;j<arr.length-1-i;j++){
              if(arr[j] > arr[j+1]){
                  flag = true;
                 int temp = arr[j];
                 arr[j] = arr[j+1];
                 arr[j+1] = temp;
              }
          }
          if(!flag) break;
       }
    }

}
