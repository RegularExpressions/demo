package struct_acm.stack;

import lombok.Data;

public class StackLinked<T> implements IStack<T>{
    private final int maxSize;
    private int top = -1;
    private final Node<T> head;
    private Node<T> topNode;

    public StackLinked(int capacity){
        this.maxSize = capacity;
        this.head = new Node<>(null);
        this.topNode = head;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize -1;
    }

    @Override
    public void push(T element) {
       if(isFull()){
           System.out.println("栈满");
           return;
       }
       Node<T> elementNode = new Node<>(element);
       topNode.nextNode = elementNode;
       elementNode.preNode = topNode;
       topNode = elementNode;
       top++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("栈空");
            return null;
        }
        T val = topNode.value;
        topNode.preNode.nextNode = topNode.nextNode;
        topNode = topNode.preNode;
        top--;
        return val;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("栈空");
            return null;
        }
        return topNode.value;
    }

    @Override
    public void list() {
       if(isEmpty()){
           System.out.println("栈空");
           return;
       }
       Node<T> cur = topNode;
       int index = top;
       while (cur != head){
           System.out.printf("stack[%d]=%s\n",index,cur.value);
           cur = cur.preNode;
           index--;
       }
    }


    @Data
    static class Node<T>{
        private T value;
        private Node<T> preNode = null;
        private Node<T> nextNode = null;

        public Node(T value){
            this.value = value;
        }
    }


    public static void main(String[] args) {
        IStack<Integer> stack = new StackLinked<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.list();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
