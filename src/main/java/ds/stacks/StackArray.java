package ds.stacks;

import java.util.NoSuchElementException;

public class StackArray<T> {
    private Object[] data = new Object[8];
    private int size;

    public int size(){ return size; }
    public boolean isEmpty(){ return size==0; }

    public void push(T v){
        if(size==data.length){
            Object[] nd=new Object[data.length*2];
            System.arraycopy(data,0,nd,0,size);
            data=nd;
        }
        data[size++]=v;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(size==0) throw new NoSuchElementException();
        return (T) data[size-1];
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if(size==0) throw new NoSuchElementException();
        T v=(T) data[--size];
        data[size]=null;
        return v;
    }

    public void clear(){ for(int i=0;i<size;i++) data[i]=null; size=0; }
}
