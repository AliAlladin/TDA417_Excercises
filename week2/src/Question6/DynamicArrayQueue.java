package Question6;

import Question6.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: Add documentation, including time complexity for each method

class DynamicArrayQueue<Item> implements Queue<Item>, Iterable<Item>{

    private static final int INITIAL_CAPACITY = 4;

    private Item[] queue;
    private int head;
    private int tail;
    private int size;
    // Note: if head==tail, the stack can be either empty or full,
    // therefore we include a size variable.

    @SuppressWarnings("unchecked")
    public DynamicArrayQueue() {
        queue = (Item[]) new Object[INITIAL_CAPACITY];
        head = tail = size = 0;
    }

    public void enqueue(Item x) {
        if (head == tail && !isEmpty()){
            resize(2 * queue.length);
        }
        queue[tail] = x;
        tail = (tail + 1) % queue.length;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (size == queue.length/4){
            resize(queue.length / 2);
            head = 0;
            tail = size;
        }
        Item dequeued = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;

        size--;
        return dequeued;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        // We don't want to go below the INITIAL_CAPACITY
        if (capacity < INITIAL_CAPACITY) return;
        Item[] newQueue = (Item[]) new Object[capacity];
        int counter = 0;
        for (int i = head; i < queue.length ; i++) {
            newQueue[counter] = queue[i];
            counter++;
        }
        for (int i = 0; i < tail; i++) {
            newQueue[counter] = queue[i];
            counter++;
        }
        queue = newQueue;
        head = 0;
        tail = size;
    }

    /**
     * Gives the element on the top of the stack.
     * Time Complexity:  O(1)
     * @return the element at the top of the stack.
     */
    public Item peek() {
        return queue[size-1];
    }

    /**
     * Checks if the queue is empty or not by looking at the size variable.
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

    // Iterate through all elements in the queue, in the order they will be removed
    public Iterator<Item> iterator() {
       return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() {
            return i < size;
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item x = queue[(i + head) % queue.length];
            i += 1;
            return x;
        }
    }


    // Code for testing the class from the command line
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: give some command line arguments, '-' means dequeue(), all others mean enqueue()");
            System.exit(1);
        }
        DynamicArrayQueue<String> queue = new DynamicArrayQueue<String>();
        for (String item : args) {
            if (!item.equals("-")) {
                queue.enqueue(item);
            } else if (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            } else {
                System.out.println("Error: queue is empty, cannot dequeue()!");
            }
        }
        System.out.print("(" + queue.size() + " items left in queue:");
        for (String item : queue) System.out.print(" " + item);
        System.out.println(")");
    }

}

