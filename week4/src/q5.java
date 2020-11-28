import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Spliterator;
import java.util.function.Consumer;

public class q5 {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 10; i > 0; i--) {
            maxHeap.add(i);
        }

        maxHeap.remove();
        maxHeap.remove();

        for (Object i : maxHeap) {
            System.out.println(i);
        }

    }
}

class MaxHeap<E extends Comparable> implements Iterable{

    PriorityQueue<E> maxHeap;

    public MaxHeap() {
        maxHeap = new PriorityQueue<>(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                if (o1.compareTo(o2) < 0){
                    return 1;
                } else if (o1.compareTo(o2) > 0){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

    }

    public void add (E e){
        maxHeap.add(e);
    }

    public E remove () {
        return maxHeap.remove();
    }

    public E getMax () {
        return maxHeap.peek();
    }

    @Override
    public Iterator iterator() {
        return maxHeap.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        maxHeap.forEach(action);
    }

    public int size() {
        return maxHeap.size();
    }
}