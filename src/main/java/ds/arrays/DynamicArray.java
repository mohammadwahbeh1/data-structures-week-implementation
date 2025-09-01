package ds.arrays;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] data;
    private int size;

    public DynamicArray() { this(8); }

    public DynamicArray(int capacity) {
        if (capacity < 1) capacity = 1;
        data = new Object[capacity];
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    @SuppressWarnings("unchecked")
    public T get(int index) { checkIndex(index); return (T) data[index]; }

    public void set(int index, T value) { checkIndex(index); data[index] = value; }

    public void add(T value) { ensureCapacity(size + 1); data[size++] = value; }

    public void add(int index, T value) {
        if (index < 0 || index > size)  throw new IndexOutOfBoundsException("Index " + index + " out of bounds. Size = " + size);
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        checkIndex(index);
        T old = (T) data[index];
        int moved = size - index - 1;
        if (moved > 0) System.arraycopy(data, index + 1, data, index, moved);
        data[--size] = null;
        shrinkIfNeeded();
        return old;
    }

    public boolean remove(T value) {
        for (int i = 0; i < size; i++) {
            if (value == null ? data[i] == null : value.equals(data[i])) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (value == null ? data[i] == null : value.equals(data[i])) return true;
        }
        return false;
    }

    public void clear() { Arrays.fill(data, 0, size, null); size = 0; shrinkIfNeeded(); }

    private void ensureCapacity(int min) {
        if (min > data.length) data = Arrays.copyOf(data, Math.max(min, data.length * 2));
    }

    private void shrinkIfNeeded() {
        int cap = data.length;
        if (cap > 8 && size <= cap / 4) data = Arrays.copyOf(data, Math.max(8, cap / 2));
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("...");
    }
}
