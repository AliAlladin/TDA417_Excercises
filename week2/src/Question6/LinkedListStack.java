package Question6;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: Add documentation, including time complexity for each method!

class LinkedListStack<Item> implements Stack<Item>, Iterable<Item>{

    private Node head;
    private int size;

    private class Node {
        Item value;
        Node next;
        Node(Item x, Node n) {
            value = x;
            next = n;
        }
    }

    public LinkedListStack() {
        head = null;
        size = 0;
    }

    /**
     * Method adds an item to the stack by creating a new node, pointing the head to it and increasing the size.
     * Time Complexity: O(1)
     * @param x item to be added on to the stack-
     */
    public void push(Item x) {
        Node newNode = new Node(x, head);
        head = newNode;
        size++;
    }

    /**
     * Removes and returns the top element from the stack by saving the value of the top Node in a temporary variable,
     * pointing the head to the second-last element, decreasing the size and then returning the value saved to tmp.
     * Time Complexity: O(n)
     * @return the element popped from the stack.
     */
    public Item pop() {
        Item popped = head.value;
        head = head.next;
        size--;
        return popped;
    }

    /**
     * Returns the head's value.
     * Time Complexity: O(1)
     * @return the value att the top of the stack.
     */
    public Item peek() {
        return head.value;
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
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = head;
        public boolean hasNext()  {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item value = current.value;
            current = current.next; 
            return value;
        }
    }


    // Code for testing the class from the command line
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: give some command line arguments, '-' means pop(), all others mean push()");
            System.exit(1);
        }
        LinkedListStack<String> stack = new LinkedListStack<String>();
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

