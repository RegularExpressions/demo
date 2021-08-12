package struct_acm.stack;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式 计算器运算实现（只支持正整数运算）
 */
public class AfterExpressCalculate {
    public static void main(String[] args) {
//        String express = "3 4 + 5 * 6 -"; //(3+4)×5-6
//        List<String> split = Splitter.on(" ").trimResults().splitToList(express);
//        System.out.println("计算结果为："+calculate(split));


//        List<String> midExpressList = splitExpressToList("1+((2+3)*4)-5");

        //8-2*2-2+2-4
        List<String> midExpressList = splitExpressToList("8-2*2-2+2-4");
        System.out.println("中缀表达式数组为："+midExpressList);
        System.out.println("后缀表达式数组为："+midExpressToAfterExpress(midExpressList));
        System.out.println("计算结果为："+calculate(midExpressToAfterExpress(midExpressList)));
    }


    /**
     * 利用栈进行后缀表达式计算,计算过程如下：
     * 1。扫描后缀表达式，如果 当前字符 是数字，直接入栈
     * 2. 如果 当前字符 是操作符，则从栈中pop出两个数，并将这两个数按照 当前操作符 进行计算，计算得出结果入栈
     * 3. 上述流程完成后，栈中只剩一个元素，即为最终结果
     *
     * @param expressList
     * @return
     */
    private static int calculate(List<String> expressList) {
        Stack<String> numStack = new Stack<>();
        for (String element : expressList) {
            if (element.matches("\\d+")) {
                numStack.push(element);
            } else {
                int num2 = Integer.parseInt(numStack.pop());
                int num1 = Integer.parseInt(numStack.pop());
                int res;
                switch (element) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    default:
                        throw new RuntimeException("操作符不支持");
                }
                numStack.push("" + res);
            }
        }
        return Integer.parseInt(numStack.pop());
    }


    /**
     * 1+((2+3)×4)-5
     * 将表达式正确分割为List数组
     *
     * @param express
     * @return
     */
    private static List<String> splitExpressToList(String express) {
        List<String> result = new ArrayList<>();
        int index = 0;
        do {
            //如果扫描到的 当前字符 在ascii码中 不为数字（即当前字符为操作符）
            if (express.charAt(index) < 48 || express.charAt(index) > 57) {
                result.add("" + express.charAt(index));
                index++;
            } else { //如果扫描到的 当前字符 在ascii码中 为数字（即当前字符为数字）
                //考虑多位数情况
                StringBuilder num = new StringBuilder();
                while (index < express.length() && express.charAt(index) >= 48 && express.charAt(index) <= 57) {
                    num.append(express.charAt(index));
                    index++;
                }
                result.add(num.toString());
            }

        } while (index < express.length());


        return result;
    }


    /**
     * [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
     * /**
     * * 中缀表达式转换为 后缀表达式
     * * 1) 初始化两个栈：运算符栈 s1 和储存中间结果的栈 s2；
     * * 2) 从左至右扫描中缀表达式；
     * * 3) 遇到操作数时，将其压 s2；
     * * 4) 遇到运算符时，比较其与 s1 栈顶运算符的优先级：
     * *   1.如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * *   2.否则，若优先级比栈顶运算符的高，也将运算符压入 s1；
     * *   3.否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较；
     * * 5) 遇到括号时：
     * *   (1) 如果是左括号“(”，则直接压入 s1
     * *   (2) 如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
     * * 6) 重复步骤 2 至 5，直到表达式的最右边
     * * 7) 将 s1 中剩余的运算符依次弹出并压入 s2
     * * 8) 依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     * *
     * * @param midExpressList
     * * @return  [1, 2, 3, +, 4, *, +, 5, -]
     */
    private static List<String> midExpressToAfterExpress(List<String> midExpressList) {
        List<String> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(midExpressList)) return result;
        Stack<String> operateStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();

        for (String item : midExpressList) {
            //如果当前字符为数字，直接入结果栈
            if (item.matches("\\d+")) {
                resultStack.push(item);
            } else { //如果 当前字符 为 操作符
                //如果 操作数栈为空，则直接将当前操作符直接入栈
                if (operateStack.isEmpty()) {
                    operateStack.push(item);
                } else if (item.equalsIgnoreCase("(")) {
                    //如果当前符号 是左括号，则直接入栈
                    operateStack.push(item);
                } else if (item.equalsIgnoreCase(")")) { //考虑 左右括号的 情况
                    while (!operateStack.isEmpty() && !operateStack.peek().equalsIgnoreCase("(")) {
                        resultStack.push(operateStack.pop());
                    }

                    operateStack.pop(); //消除 左括号
                } else { //当前元素 为 + or - or * or /
                    //判断 当前操作符与操作符栈顶 优先级 ，如果当前操作符优先级 <= 操作符栈顶 则  结果栈push(操作数栈pop)，
                    // 注意当前元素 要与 操作符栈元素进行多次比较
                    // 左括号优先级为0，其余操作符优先级 必定大于 左括号优先级 Operation.getPriority(其他操作符) <= Operation.getPriority(左括号) always false
                    while (!operateStack.isEmpty() && Operation.getPriority(item) <= Operation.getPriority(operateStack.peek())) {
                        resultStack.push(operateStack.pop());
                    }
                    operateStack.push(item); //记得将当前操作符入栈
                }
            }
        }

        /**
         * 将 operateStack 剩余的元素全部压入 resultStack中
         */
        while (!operateStack.isEmpty()) {
            resultStack.push(operateStack.pop());
        }


        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop());
        }

        return Lists.reverse(result);
    }


    static class Operation {
        private static final int ADD = 1;
        private static final int SUB = 1;
        private static final int MUL = 2;
        private static final int DIV = 2;

        private static int getPriority(String operation) {
            int result = 0;
            switch (operation) {
                case "+":
                    result = ADD;
                    break;
                case "-":
                    result = SUB;
                    break;
                case "*":
                    result = MUL;
                    break;
                case "/":
                    result = DIV;
                    break;
            }
            return result;
        }
    }

}
