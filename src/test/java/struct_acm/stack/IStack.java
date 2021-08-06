package struct_acm.stack;

public interface IStack<T> {
    boolean isEmpty();
    
    boolean isFull();

    void push(T element);

    T pop();

    T peek();

    void list();
}
