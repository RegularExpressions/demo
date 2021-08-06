package struct_acm.stack;

/**
 * 用数组实现栈
 */
public class StackArray<T> implements IStack<T>{
    private int top = -1; //栈顶
    private final Object[] data; //存储栈元素的数组
    private final int maxSize; //栈的最大长度

    public StackArray(int capacity){
        this.maxSize = capacity;
        data = new Object[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize-1;
    }

    @Override
    public void push(T element) {
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        data[top] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty()){
            System.out.println("栈空");
            return null;
        }
        T val = (T) data[top];
        top--;
        return val;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek(){
        if(isEmpty()){
            System.out.println("栈空");
            return null;
        }
        return (T) data[top];
    }

    @Override
    public void list() {
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }

        for (int i = top;i >=0;i--){
            System.out.printf("stack[%d]=%s\n",i,data[i].toString());
        }
    }


    public static void main(String[] args) {
        IStack<Integer> stack = new StackArray<>(5);
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
