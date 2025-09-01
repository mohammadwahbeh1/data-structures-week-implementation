package ds.linkedlists;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private static class Node<T> { T val; Node<T> next; Node(T v){val=v;} }

    private Node<T> head, tail;
    private int size;

    public int size(){ return size; }
    public boolean isEmpty(){ return size==0; }

    public void addFirst(T v){
        Node<T> n=new Node<>(v); n.next=head; head=n; if(tail==null) tail=n; size++;
    }
    public void addLast(T v){
        Node<T> n=new Node<>(v);
        if(tail==null){ head=tail=n; }
        else { tail.next=n; tail=n; }
        size++;
    }
    public void add(int index, T v){
        if(index<0||index>size) throw new IndexOutOfBoundsException();
        if(index==0){ addFirst(v); return; }
        if(index==size){ addLast(v); return; }
        Node<T> prev = nodeAt(index-1);
        Node<T> n = new Node<>(v);
        n.next = prev.next; prev.next = n; size++;
    }

    public T get(int index){ return nodeAt(index).val; }
    public void set(int index, T v){ nodeAt(index).val = v; }

    public T removeFirst(){
        if(head==null) throw new NoSuchElementException();
        T val=head.val; head=head.next; if(head==null) tail=null; size--; return val;
    }
    public T removeLast(){
        if(head==null) throw new NoSuchElementException();
        if(head==tail){ T v=head.val; head=tail=null; size=0; return v; }
        Node<T> prev=head; while(prev.next!=tail) prev=prev.next;
        T v=tail.val; tail=prev; tail.next=null; size--; return v;
    }
    public T removeAt(int index){
        if(index<0||index>=size) throw new IndexOutOfBoundsException();
        if(index==0) return removeFirst();
        Node<T> prev=nodeAt(index-1);
        T v=prev.next.val;
        prev.next=prev.next.next;
        if(index==size-1) tail=prev;
        size--;
        return v;
    }
    public boolean remove(T value){
        if(head==null) return false;
        if(value==null? head.val==null : value.equals(head.val)){ removeFirst(); return true; }
        Node<T> prev=head;
        while(prev.next!=null){
            if(value==null? prev.next.val==null : value.equals(prev.next.val)){
                if(prev.next==tail) tail=prev;
                prev.next=prev.next.next; size--; return true;
            }
            prev=prev.next;
        }
        return false;
    }
    public boolean contains(T value){
        for(Node<T> cur=head; cur!=null; cur=cur.next){
            if(value==null? cur.val==null : value.equals(cur.val)) return true;
        }
        return false;
    }

    private Node<T> nodeAt(int index){
        if(index<0||index>=size) throw new IndexOutOfBoundsException();
        Node<T> cur=head; for(int i=0;i<index;i++) cur=cur.next; return cur;
    }
}
