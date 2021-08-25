package struct_acm.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * 八皇后问题
 */
public class Queen8 {
    int max = 8;
    //定义数组 array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    private void check(int n){
        if(n==max){
            print();
            return;
        }
        for (int i=0;i<max;i++){
            //先把当前这个皇后 n , 放到该行的第 1 列
            array[n] = i;
            //判断当放置第 n 个皇后到 i 列时，是否冲突
            if(judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        judgeCount++;
        for (int i=0;i<n;i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
//        Queen8 queen8 = new Queen8();
//       queen8.check(0);
//        System.out.printf("一共有%d 解法", count);
//        System.out.printf("一共判断冲突的次数%d 次", judgeCount);
    }

    private static void test(Long... test){
//        String regex = "((http|ftp|https)://[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?)";
//        String url="http://127.0.0.1";
//        System.out.println(url.matches(regex));
        System.out.println(System.currentTimeMillis());
        String a = "a";
        System.out.println(a.getClass().getName());
    }


}
