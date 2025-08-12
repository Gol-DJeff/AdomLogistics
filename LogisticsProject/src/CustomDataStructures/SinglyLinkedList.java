package CustomDataStructures;

public class SinglyLinkedList<E> {
    protected NodeElements<E> head;
    protected NodeElements<E> tail;
    protected int size;

    // Constructor initializes head, tail, and size
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insert at front of the list
    public void insertFront(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }
        NodeElements<E> newNode = new NodeElements<>();
        newNode.SinglyNodeElements(element);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    // Remove from front of the list
    public void removeFront() {
        if (head == null) {
            throw new IllegalStateException("Cannot remove from front: List is empty.");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    // Insert at back of the list
    public void insertBack(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }
        NodeElements<E> newNode = new NodeElements<>();
        newNode.SinglyNodeElements(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove from back of the list
    public void removeBack() {
        if (head == null) {
            throw new IllegalStateException("Cannot remove from back: List is empty.");
        }
        if (head == tail) {
            head = tail = null;
        } else {
            NodeElements<E> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    public void displayList() {
        NodeElements<E> current = head;
        if (current == null) {
            System.out.println("Empty list");
            return;
        }
        System.out.println("<-- Start");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("End -->");
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public NodeElements<E> getNodeAt(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        }
        NodeElements<E> current = head;
        int index = 0;
        while (index < i) {
            current = current.next;
            index++;
        }
        return current;
    }

    public void displayNodeAt(int i) {
        if (i < 0 || i >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        E display = getNodeAt(i).data;
        System.out.println("Node at index " + i + ": " + display);
    }
}
