package ds.nonlinear;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    public void insert(int val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap.get(idx) >= heap.get(parent)) break;
            swap(idx, parent);
            idx = parent;
        }
    }

    private void siftDown(int idx) {
        int n = heap.size();
        while (true) {
            int left = idx * 2 + 1, right = idx * 2 + 2, smallest = idx;
            if (left < n && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest)) smallest = right;
            if (smallest == idx) break;
            swap(idx, smallest);
            idx = smallest;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public boolean isEmpty() { return heap.isEmpty(); }
    public int size() { return heap.size(); }
}
