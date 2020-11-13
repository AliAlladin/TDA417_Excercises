package Question6;

import Question6.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: Add documentation, including time complexity for each method

class DynamicArrayStack<Item> implements Stack<Item>, Iterable<Item> {

    private static final int INITIAL_CAPACITY = 4;

    private Item[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArrayStack() {
        stack = (Item[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Method adds an item to the stack by adding the value to the array if there's space, or resizing it first if it's
     * full.
     * Time Complexity: O(1)
     * @param x item to be added on to the stack.
     */
    public void push(Item x) {
        if (size == stack.length){
            resize(stack.length*2);
        }
        stack[size] = x;
        size++;
    }

    /**
     * Removes and returns the element on top of the stack by making a tmp variable point to the last item in the stack
     * (Array), making the last index point to null, decreasing the size and returning tmp.
     * Time Complexity: O(1)
     * @return the element popped from the stack.
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        if (size == stack.length / 4){
            resize(stack.length/2);
        }
        Item popped = stack[size-1];
        stack[size-1] = null;
        size--;
        return popped;
    }

    /**
     * Resizes the array to the desired capacity by creating a new array and copying over all elements to it.
     * Time Complexity: O(n)
     * @param capacity the desired size of the resized array.
     */
    private void resize(int capacity) {
        // We don't want to go below the INITIAL_CAPACITY
        if (capacity < INITIAL_CAPACITY) return;
        Item[] newStack = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    /**
     * Gives the element on the top of the stack.
     * Time Complexity:  O(1)
     * @return the element at the top of the stack.
     */
    public Item peek() {
        return stack[size-1];
    }

    /**
     * Checks if the Stack is empty or not by looking at the size variable.
     * Time Complexity: O(1)
     * @return true if size is 0, else false.
     */
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    /**
     * Gives the size of the Stack.
     * Time Complexity: O(1)
     * @return the value of the size-variable.
     */
    public int size() {
        return size;
    }

    // Iterate through all elements in the stack, in the order they will be removed
    public Iterator<Item> iterator() {
       return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        public ReverseArrayIterator() {
            i = size - 1;
        }
        public boolean hasNext() {
            return i >= 0;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item x = stack[i];
            i -= 1;
            return x;
        }
    }


    // Code for testing the class from the command line
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: give some command line arguments, '-' means pop(), all others mean push()");
            System.exit(1);
        }
        DynamicArrayStack<String> stack = new DynamicArrayStack<String>();
        for (String item : args) {
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                System.out.println(stack.pop());
            } else {
                System.out.println("Error: stack is empty, cannot pop()!");
            }
        }
        System.out.print("(" + stack.size() + " items left on stack:");
        for (String item : stack) System.out.print(" " + item);
        System.out.println(")");
    }

}

