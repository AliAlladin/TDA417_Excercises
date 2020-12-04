import java.util.ArrayList;

public class q4 {
    public static void main(String[] args) {
        LinearProbingHashSet<Integer> hashSet = new LinearProbingHashSet<>();
        for (int i = 0; i < 10; i++) {
            hashSet.add(i);
        }
    }
}

class LinearProbingHashSet<Item>{
    ArrayList<Item> table = new ArrayList<>(1);
    int size = 0;

    void add (Item x){
        int i = x.hashCode();
        while (table.get(i) != null){
            if (table.get(i).equals(x)){
                return;
            }
            i = (i+1) % table.size();
        }
        table.add(i, x);
        size++;
    }

    void remove(Item x){
        int i = x.hashCode();
        while (table.get(i).equals(x)){
            if (x == table.get(i)){
                table.set(i, null);
            }
            i = (i+1) % table.size();
        }
    }
}