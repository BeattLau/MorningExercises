package Stack_20_10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class CustomStack<T> {
    private Deque<T> stack;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.stack = new ArrayDeque<>();
        this.maxSize = maxSize;
    }

    public void push(T j) {
        if (isFull()) {
            resize(maxSize * 2);
        }
        stack.push(j);
    }

    private void resize(int newCapacity) {
        Deque<T> newStack = new ArrayDeque<>(newCapacity);
        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        stack = newStack;
    }

    public int size() {
        return stack.size();
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop an element.");
        }
        return stack.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.size() >= maxSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> iterator = stack.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack<>(10);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.push(6);
        customStack.push(7);
        customStack.push(8);
        customStack.push(9);
        customStack.push(10);

        System.out.println(customStack);

        while (!customStack.isEmpty()) {
            int poppedValue = customStack.pop();
            System.out.println("Popped value: " + poppedValue);

            System.out.println(customStack);
        }
    }
}