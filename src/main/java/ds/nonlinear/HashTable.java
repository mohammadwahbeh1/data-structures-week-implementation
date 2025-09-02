package ds.nonlinear;


import java.util.LinkedList;

public class HashTable<K, V> {
    private class Entry {
        K key;
        V value;
        Entry(K k, V v) { key = k; value = v; }
    }

    private LinkedList<Entry>[] table;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int idx = hash(key);
        if (table[idx] == null) table[idx] = new LinkedList<>();
        for (Entry e : table[idx]) {
            if (e.key.equals(key)) { e.value = value; return; }
        }
        table[idx].add(new Entry(key, value));
        size++;
    }

    public V get(K key) {
        int idx = hash(key);
        if (table[idx] != null) {
            for (Entry e : table[idx]) {
                if (e.key.equals(key)) return e.value;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int idx = hash(key);
        if (table[idx] != null) {
            var iter = table[idx].iterator();
            while (iter.hasNext()) {
                Entry e = iter.next();
                if (e.key.equals(key)) {
                    iter.remove();
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() { return size; }
}

