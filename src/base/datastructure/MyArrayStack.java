package base.datastructure;

public class MyArrayStack<T> {
    T[] items;
    int count;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayStack() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public T pop() {
        if (count > 0) {
            return items[count--];
        }
        return null;
    }

    public void push(T data) {
        items[++count] = data;
    }
}
