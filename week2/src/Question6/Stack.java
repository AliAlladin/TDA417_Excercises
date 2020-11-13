package Question6;

public interface Stack<Item> {
    void push(Item x);
    Item pop();
    Item peek();
    // from Collection: isEmpty(), size()
    // from Iterable: iterator()
}
