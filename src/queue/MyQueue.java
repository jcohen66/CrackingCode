package queue;

import java.util.NoSuchElementException;

/**
 * Created by jcohe_000 on 3/17/2016.
 */
public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> t = new QueueNode<T>(item);
        if( last != null) {
            last.next = t;
        }
        last = t;
        if( first == null ) {
            first = last;
        }
    }

    public T remove() {
        if( first == null ) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if( first == null ) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if( first == null ) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        myQueue.add(1);
        myQueue.add(95);
        myQueue.add(23);


        while(!myQueue.isEmpty()) {
            System.out.println(myQueue.remove());
        }
    }
}
