package struct_acm;

import java.util.Scanner;

/**
 * 队列-循环数组实现
 * 1-》2-》3-》null
 */
public class ArrayQueue<T> {
    private int rear;
    private int front;
    private final int maxSize;
    private final Object[] data;

    public ArrayQueue(int capacity) {
        this.maxSize = capacity+1;
        data = new Object[maxSize];
        this.rear = 0;  //指向数组尾部+1
        this.front = 0; //指向数组第一个元素
    }

    /**
     * 入队
     *
     * @param element
     */
    public void add(Object element) {
        //队列满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }

        data[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 出队
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T get() {
        if (isEmpty()) {
            System.out.println("队列空");
            return null;
        }
        T val = (T) data[front];
        front = (front + 1) % maxSize;

        return val;
    }

    /**
     * 弹出队头
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("队列空");
            return null;
        }
        return (T) data[front];
    }

    /**
     * 打印队列
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        
        int head = front, root = rear;
        while (head != root) {
            System.out.printf("arr[%d]=%s\n", head, data[head]);
            head = (head + 1) % maxSize;
        }

    }

    /**
     * 获取队列有效长度
     *
     * @return
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> myCycleArrayQueue = new ArrayQueue<>(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0); //接收一个字符

            switch (key) {
                case 's':
                    myCycleArrayQueue.list();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    myCycleArrayQueue.add(value);
                    break;
                case 'g':
                    Integer queue = myCycleArrayQueue.get();
                    System.out.println("取出的数据是：" + queue);
                    break;
                case 'h':
                    Integer peek = myCycleArrayQueue.peek();
                    System.out.println("队列头数据是：" + peek);
                    break;
                default:
            }
        }
        System.out.println("程序退出");
    }
}
