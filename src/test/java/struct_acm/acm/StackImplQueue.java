package struct_acm.acm;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 */
public class StackImplQueue {

    private final Stack<Integer> firstStack;

    private final Stack<Integer> secondStack;

    public StackImplQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void appendTail(int value) {
        firstStack.push(value);
    }

    public int deleteHead() {
        if (secondStack.empty()) {
            while (!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
        }
        if (secondStack.empty()) return -1;
        return secondStack.pop();
    }

    public static void main(String[] args) {
        StackImplQueue queue = new StackImplQueue();
        queue.deleteHead();
        queue.deleteHead();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }

}
