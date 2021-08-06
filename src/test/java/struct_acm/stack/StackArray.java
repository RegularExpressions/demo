package struct_acm.stack;

/**
 * 用数组实现栈
 */
public class StackArray<T> implements IStack{
    private int top = -1; //栈顶
    private Object[] data; //存储栈元素的数组
    private int maxSize; //栈的最大长度

    public StackArray(int capacity){
        this.maxSize = capacity;
        data = new Object[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


}
