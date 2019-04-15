package base.datastructure;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    public T mItems[];
    public int mCount;

    public MyArrayList() {
        mItems = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator<>();
    }

    public int size() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount == 0;
    }

    public void add(T value) {
        add(size(), value);
    }

    public void expandArray() {
        T old[] = mItems;
        mItems = (T[]) new Object[mItems.length * 2];
        for (int i = 0; i < size(); i++) {
            mItems[i] = old[i];
        }
    }

    public void add(int index, T value) {
        if (size() == mItems.length) {
            expandArray();
        }
        for (int i = size(); i > index; i--) {
            mItems[i] = mItems[i - 1];
        }
        mItems[index] = value;
        mCount++;
    }

    public T remove(int index) {
        System.out.println("index: " + index);
        T needToRemove = mItems[index];
        for (int i = index; i < size(); i++) {
            mItems[i] = mItems[i + 1];
        }
        mCount--;
        return needToRemove;
    }

    public T get(int index) {
        return mItems[index];
    }

    public void clear() {
        mCount = 0;
        mItems = (T[]) new Object[DEFAULT_CAPACITY];
    }

    class MyArrayListIterator<T> implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {

            return current < size();
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public T next() {
            return (T) mItems[current++];
        }
    }
}
