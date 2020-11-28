import java.util.PriorityQueue;

public class q7 {
    public static void main(String[] args) {
        Datastructure<Integer> numbers = new Datastructure<>();
        for (int i = 1; i < 6; i++) {
            numbers.add(i);
        }
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);

        System.out.println(numbers.median);
        System.out.println(numbers.removeMedian());
        System.out.println(numbers.median);
    }
}

class Datastructure<Item extends Comparable> {
    MaxHeap<Item> smaller = new MaxHeap<>();
    Item median;
    PriorityQueue<Item> larger = new PriorityQueue<>();


    public void add(Item item) {
        if (median == null) {
            median = item;
        } else if (item.compareTo(median) <= 0) {
            smaller.add(item);
        } else {
            larger.add(item);
        }

        if (smaller.size() - larger.size() > 1){
            larger.add(median);
            median = smaller.remove();
        }
        if (larger.size() - smaller.size() > 1){
            smaller.add(median);
            median = larger.remove();
        }

    }

    public Item removeMedian() {
        Item medianTmp = median;

        if (smaller.size() == 0 && larger.size() == 0){
            median = null;
            return medianTmp;
        }

        if (smaller.size() >= larger.size()){
            median = smaller.remove();
        } else {
            median = larger.remove();
        }
        return medianTmp;
    }

    public Item median() {
        return median;
    }
}
