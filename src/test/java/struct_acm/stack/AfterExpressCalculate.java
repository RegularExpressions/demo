package struct_acm.stack;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式 计算器运算实现
 */
public class AfterExpressCalculate {
    public static void main(String[] args) {
        String express = "3 4 + 5 * 6 -"; //(3+4)×5-6
        List<String> split = Splitter.on(" ").trimResults().splitToList(express);
        System.out.println("计算结果为："+calculate(split));
    }


    /**
     * 利用栈进行后缀表达式计算,计算过程如下：
     *   1。扫描后缀表达式，如果 当前字符 是数字，直接入栈
     *   2. 如果 当前字符 是操作符，则从栈中pop出两个数，并将这两个数按照 当前操作符 进行计算，计算得出结果入栈
     *   3. 上述流程完成后，栈中只剩一个元素，即为最终结果
     * @param expressList
     * @return
     */
    private static int calculate(List<String> expressList){
        Stack<String> numStack = new Stack<>();
        for (String element:expressList){
            if(element.matches("\\d+")){
               numStack.push(element);
            }else {
                int num2 = Integer.parseInt(numStack.pop());
                int num1 = Integer.parseInt(numStack.pop());
                int res;
                switch (element){
                    case "+":
                        res = num1+num2;
                        break;
                    case "-":
                        res = num1-num2;
                        break;
                    case "/":
                        res = num1/num2;
                        break;
                    case "*":
                        res = num1*num2;
                        break;
                    default:
                        throw new RuntimeException("操作符不支持");
                }
                numStack.push(""+res);
            }
        }
        return Integer.parseInt(numStack.pop());
    }

}
