package Question6;

import Question6.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: Add documentation, including time complexity for each method

public class LinkedListQueue<Item> implements Queue<Item>, Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item value;
        Node next;
        Node(Item x, Node n) {
            value = x;
            next = n;
        }
    }

    public LinkedListQueue() {
        first = last = null;
        size = 0;
    }

    /**
     * If the list is empty then the first and last are pointed towards a new node in which the item is saved that is
     * created. Else the node and then adds it to the end of list. If the list is empty then the first and last are
     * pointed towards the node.
     * Time Complexity: O(1)
     * @param x the Item that wants to be enqueued.
     */
    public void enqueue(Item x) {
        // TODO
        // Note: be aware of the special case when the queue is empty
        Node newNode = new Node(x, null);
        if (isEmpty()){
            first = newNode;
        }
        else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    /**
     * The method removes and returns the first value in the queue.
     * Time Complexity: O(1)
     * @return the first item in the queue.
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        // TODO
        // Note: be aware of the special case when the queue becomes empty
        Item dequeued = first.value;
        if (size == 1){
            last = null;
        }
        first = first.next;
        size--;
        return dequeued;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return last.value;
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    // Iterate through all elements in the queue, in the order they will be removed
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = first;
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
            System.err.println("Usage: give some command line arguments, '-' means dequeue(), all others mean enqueue()");
            System.exit(1);
        }
        LinkedListQueue<String> queue = new LinkedListQueue<String>();
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

