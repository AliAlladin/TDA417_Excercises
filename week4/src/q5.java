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

        maxHeap.remove(1);
        maxHeap.remove(2);

        for (Integer i : maxHeap) {
            System.out.println(i);
        }
    }
}

class MaxHeap<E> extends  PriorityQueue<E>{

    public E getMax () {
        return this.peek();
    }

    @Override
    public Comparator<? super E> comparator() {
        return new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                if ((Integer) o1 < (Integer) o2){
                    return 1;
                } else if ((Integer) o1 > (Integer) o2){
                    return -1;
                } else {
                    return 0;
                }

            }
        };
    }
}