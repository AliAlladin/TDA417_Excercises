package Question6;

public interface Queue <Item>{
    void enqueue(Item x);
    Item dequeue();
    Item peek();
    // from Collection: isEmpty(), size()
    // from Iterable: iterator()
}
