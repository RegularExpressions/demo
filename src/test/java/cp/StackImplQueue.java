package cp;

import java.util.Stack;

public class StackImplQueue {
    private final Stack<Integer> firstStack = new Stack<>();
    private final Stack<Integer> secondStack = new Stack<>();

    public void offer(Integer val){
      firstStack.push(val);
    }

    public Integer poll(){
        if(secondStack.isEmpty()){
            while (!firstStack.isEmpty()){
                secondStack.push(firstStack.pop());
            }
        }
        if(secondStack.isEmpty()) return -1;
        return secondStack.pop();
    }

    public static void main(String[] args) {
        StackImplQueue queue = new StackImplQueue();
        queue.poll();
        queue.poll();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
