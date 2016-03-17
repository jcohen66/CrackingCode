package stack;

import java.util.EmptyStackException;

/**
 * Created by jcohe_000 on 3/17/2016.
 */
public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();

        T item = top.data;

        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();

        myStack.push(1);
        myStack.push(95);
        myStack.push(23);

        while(!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }

}

