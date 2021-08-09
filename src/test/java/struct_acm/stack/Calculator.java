package struct_acm.stack;

/**
 * 利用栈完成简单的计算器，两个栈实现，一个存储数字，一个存储操作符，思路如下：
 * 1.通过一个index值（索引），遍历我们的表达式
 * 2.如果发现是一个数字，直接入栈；
 * 3.如果发现是一个操作符，就分如下情况：
 * 3.1 如果操作符栈为空，则直接入栈
 * 3.2 如果符号栈不为空，且当前遍历操作符优先级 小于等于 操作数栈顶的操作符，此时需要pop两次 数栈 && pop一次 操作数栈 然后将
 * 数栈中 pop出的两个数字根据 操作符栈中pop出的操作符进行运算，计算出结果后将结果入 数栈，然后将当前操作符 入 操作符栈；
 * <p>
 * 如果符号栈不为空，且当前遍历操作符优先级 大于 操作数栈顶的操作符，就直接将 当前遍历操作符 直接入 操作符栈
 * 3.3 当表达式扫描到最后一位后（扫描完毕后），就按顺序从 数栈和符号栈 pop出对应的数和符号，并运行计算，将每一次的结果 入 数栈
 * <p>
 * 最终，最后在数栈中只有一个数字，就是表达式的结果
 *
 * 缺陷如下：
 *   8-2*2-2+2-4运算结果不对 对应数栈（从栈顶开始） 4=>4=>8 操作栈 - => -
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
//        String expression = "8-2*2-2+2-4";
//        String expression = "8-4-2+2-4";
//        String expression = "8-4/2/2-4";
//        String expression = "18-4-2+2-4";

        StackArray<Integer> numStack = new StackArray<>(10);
        StackArray<Integer> operaStack = new StackArray<>(10);

        int index = 0;
        int num1,num2,opera,res;
        char ch;
        String keepNum = "";


        while (true){
            ch = expression.charAt(index);
            if(numStack.isOperator(ch)){
               if(!operaStack.isEmpty()){
                   Integer peek = operaStack.peek();
                   if(operaStack.priority(ch) <= operaStack.priority(peek)){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opera = operaStack.pop();
                        res = numStack.calc(num1,num2,opera);
                        numStack.push(res);
                   }
               }
                operaStack.push((int) ch);
            }else {
                keepNum += ch;
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else if(operaStack.isOperator(expression.charAt(index+1))){
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
//                numStack.push(ch-48); //字符的6 映射的 int数 需要 原字符-48
            }
            index++;
            if(index >= expression.length()) break;
        }

        while (!operaStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            opera = operaStack.pop();
            res = numStack.calc(num1,num2,opera);
            numStack.push(res);
        }

        int finalRes = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, finalRes);
    }


    static class StackArray<T> implements IStack<T> {
        private int top = -1;
        private final int maxSize;
        private final Object[] data;

        public StackArray(int capacity) {
            this.maxSize = capacity;
            this.data = new Object[maxSize];
        }


        @Override
        public boolean isEmpty() {
            return top == -1;
        }

        @Override
        public boolean isFull() {
            return top == maxSize - 1;
        }

        @Override
        public void push(T element) {
            if (isFull()) {
                System.out.println("栈满");
                return;
            }
            top++;
            data[top] = element;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T pop() {
            if (isEmpty()) {
                System.out.println("栈空");
                return null;
            }
            T val = (T) data[top];
            top--;
            return val;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T peek() {
            if (isEmpty()) {
                System.out.println("栈空");
                return null;
            }
            return (T) data[top];
        }

        @Override
        public void list() {
            if (isEmpty()) {
                System.out.println("栈空");
                return;
            }
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d]=%s\n", i, data[i].toString());
            }
        }

        /**
         * 判断传入的 char 字符是否为操作符
         *
         * @param ch
         * @return
         */
       public boolean isOperator(int ch) {
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }

        /**
         * 计算结果
         * @param num1
         * @param num2
         * @param opera
         * @return
         */
        public int calc(int num1, int num2, int opera) {
            int res = 0;
            switch (opera) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
                default:
                    break;
            }
            return res;
        }

        /**
         * 返回操作符的优先级
         * @param opera
         * @return
         */
        public int priority(int opera){
            if(opera == '*' || opera == '/')
                return 2;
            else if(opera == '-')
                return 1;
            else if(opera == '+')
                return 0;
            else
                return -1;
        }

    }

}
