package base.datastructure;

public class MyArrayQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    public T mItems[];
    public int first;
    public int last;

    public MyArrayQueue() {
        mItems = (T[]) new Object[DEFAULT_CAPACITY];
        first = 0;
        last = -1;
    }

    public void enqueue(T data) {
        if (last == mItems.length - 1) {
            last = -1;
        }
        mItems[++last] = data;
    }

    public T dequeue() {
        T temp = mItems[first++];
        if (first == mItems.length)
            first = 0;

        return temp;
    }
}
