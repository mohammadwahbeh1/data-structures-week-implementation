package ds.arrays;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] data; // store elements
    private int size;      // current number of elements

    // default constructor with initial capacity 8
    public DynamicArray() { this(8); }

    // constructor with custom capacity
    public DynamicArray(int capacity) {
        if (capacity < 1) capacity = 1;
        data = new Object[capacity];
    }

    // return number of elements
    public int size() { return size; }

    // check if array is empty
    public boolean isEmpty() { return size == 0; }

    // get element at index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    // set element at index
    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    // add element at the end
    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    // add element at specific index
    public void add(int index, T value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds. Size = " + size);
        ensureCapacity(size + 1);
        // shift elements to make space
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    // remove element at index
    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        checkIndex(index);
        T old = (T) data[index];
        int moved = size - index - 1;
        // shift elements left
        if (moved > 0) System.arraycopy(data, index + 1, data, index, moved);
        data[--size] = null; // free memory
        shrinkIfNeeded();
        return old;
    }

    // remove first occurrence of value
    public boolean remove(T value) {
        for (int i = 0; i < size; i++) {
            if (value == null ? data[i] == null : value.equals(data[i])) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // check if value exists
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (value == null ? data[i] == null : value.equals(data[i]))
                return true;
        }
        return false;
    }

    // clear the array
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
        shrinkIfNeeded();
    }

    // make array bigger if needed
    private void ensureCapacity(int min) {
        if (min > data.length)
            data = Arrays.copyOf(data, Math.max(min, data.length * 2));
    }

    // shrink array if too empty
    private void shrinkIfNeeded() {
        int cap = data.length;
        if (cap > 8 && size <= cap / 4)
            data = Arrays.copyOf(data, Math.max(8, cap / 2));
    }

    // check index validity
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds. Size = " + size);
    }
}
