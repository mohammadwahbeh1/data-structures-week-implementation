package ds.linkedlists;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    // Node class: stores value and link to next node
    private static class Node<T> {
        T val;
        Node<T> next;
        Node(T v){ val = v; }
    }

    private Node<T> head, tail; // first and last nodes
    private int size;           // number of elements

    // return number of elements
    public int size(){ return size; }

    // check if list is empty
    public boolean isEmpty(){ return size == 0; }

    // add element at the front
    public void addFirst(T v){
        Node<T> n = new Node<>(v);
        n.next = head;
        head = n;
        if (tail == null) tail = n; // first element
        size++;
    }

    // add element at the end
    public void addLast(T v){
        Node<T> n = new Node<>(v);
        if (tail == null) { // empty list
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    // add element at a specific index
    public void add(int index, T v){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { addFirst(v); return; }
        if (index == size) { addLast(v); return; }
        Node<T> prev = nodeAt(index - 1);
        Node<T> n = new Node<>(v);
        n.next = prev.next;
        prev.next = n;
        size++;
    }

    // get element by index
    public T get(int index){ return nodeAt(index).val; }

    // set element value at index
    public void set(int index, T v){ nodeAt(index).val = v; }

    // remove first element
    public T removeFirst(){
        if (head == null) throw new NoSuchElementException();
        T val = head.val;
        head = head.next;
        if (head == null) tail = null; // list became empty
        size--;
        return val;
    }

    // remove last element
    public T removeLast(){
        if (head == null) throw new NoSuchElementException();
        if (head == tail) { // only one element
            T v = head.val;
            head = tail = null;
            size = 0;
            return v;
        }
        Node<T> prev = head;
        while (prev.next != tail) prev = prev.next;
        T v = tail.val;
        tail = prev;
        tail.next = null;
        size--;
        return v;
    }

    // remove element at index
    public T removeAt(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        Node<T> prev = nodeAt(index - 1);
        T v = prev.next.val;
        prev.next = prev.next.next;
        if (index == size - 1) tail = prev; // update tail if last removed
        size--;
        return v;
    }

    // remove element by value
    public boolean remove(T value){
        if (head == null) return false;
        if (value == null ? head.val == null : value.equals(head.val)) {
            removeFirst();
            return true;
        }
        Node<T> prev = head;
        while (prev.next != null) {
            if (value == null ? prev.next.val == null : value.equals(prev.next.val)) {
                if (prev.next == tail) tail = prev;
                prev.next = prev.next.next;
                size--;
                return true;
            }
            prev = prev.next;
        }
        return false;
    }

    // check if list contains a value
    public boolean contains(T value){
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            if (value == null ? cur.val == null : value.equals(cur.val)) return true;
        }
        return false;
    }

    // helper: get node at index
    private Node<T> nodeAt(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur;
    }
}
