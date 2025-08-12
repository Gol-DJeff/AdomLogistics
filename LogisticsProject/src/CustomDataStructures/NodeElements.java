package CustomDataStructures;

public class NodeElements<E> {
    E data;
    NodeElements<E> next;
    NodeElements<E> previous;

    // Constructors for singly and doubly linked nodes
    public NodeElements() {
        // Default constructor
    }

    public NodeElements(E data) {
        this.data = data;
    }

    // Initialize as singly linked node
    public void SinglyNodeElements(E data) {
        if (data == null) {
            throw new IllegalArgumentException("Node data cannot be null.");
        }
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    // Initialize as doubly linked node
    public void DoublyNodeElements(E data) {
        if (data == null) {
            throw new IllegalArgumentException("Node data cannot be null.");
        }
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
