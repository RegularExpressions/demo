package struct_acm;

import java.util.Scanner;

/**
 * 队列实现--数组（问题：此队列只能使用一次）
 * 优化方案：使用环形数组
 * @param <T>
 */
public class MyArrayQueue<T> {
    private int rear;
    private int front;
    private final int maxSize; //队列最大存储个数
    private final Object[] data;

    public MyArrayQueue(int initSize) {
        maxSize = initSize;
        data = new Object[maxSize];
        rear = -1;  //指向队列尾部（即指向队列最后一个数据）
        front = -1; //指向队列头部的前一个位置

    }

    /**
     * 添加数据到队列
     *
     * @param data
     */
    public void addQueue(Object data) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        this.data[++rear] = data;
    }

    /**
     * 出队列
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getQueue(){
        if(isEmpty()){
            System.out.println("队列空");
            return null;
        }
        front++;
        return (T) this.data[front];
    }

    /**
     * 显示头数据
     * @return
     */
    @SuppressWarnings("unchecked")
    public T peek(){
        if(isEmpty()){
            System.out.println("队列空");
            return null;
        }
        return (T) this.data[front+1];
    }
    /**
     * 判断队列是否满
     *
     * @return
     */
    private boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    private boolean isEmpty() {
        return rear == front;
    }

    /**
     * 打印队列
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，无数据~");
            return;
        }
        int root = rear;
        int head = front;
        while (head != root){
            head++;
            System.out.printf("arr[%d]=%s\n",head,data[head]);
        }
    }


    public static void main(String[] args) {
        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0); //接收一个字符

            switch (key){
                case 's':
                    myArrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    myArrayQueue.addQueue(value);
                    break;
                case 'g':
                    Integer queue = myArrayQueue.getQueue();
                    System.out.println("取出的数据是："+queue);
                    break;
                case 'h':
                    Integer peek = myArrayQueue.peek();
                    System.out.println("队列头数据是："+peek);
                    break;
                default:
            }
        }
        System.out.println("程序退出");


    }
}
