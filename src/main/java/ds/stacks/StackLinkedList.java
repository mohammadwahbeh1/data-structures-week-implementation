package ds.stacks;

import ds.linkedlists.SinglyLinkedList;

public class StackLinkedList<T> {
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();

    public int size(){ return list.size(); }
    public boolean isEmpty(){ return size()==0; }

    public void push(T v){ list.addFirst(v); }
    public T pop(){ return list.removeFirst(); }
    public T peek(){ return list.get(0); }
    public void clear(){ while(!isEmpty()) list.removeFirst(); }
}
