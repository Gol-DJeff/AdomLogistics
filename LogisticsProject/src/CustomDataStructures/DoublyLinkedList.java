package CustomDataStructures;

public class DoublyLinkedList<E> extends SinglyLinkedList<E> {

    @Override
    public void insertFront(E element) {
        NodeElements<E> newNode = new NodeElements<>();
        newNode.DoublyNodeElements(element);
        newNode.next = head;
        if (head != null) {
            head.previous = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public void removeFront() {
        if (head == null) {
            throw new IllegalStateException("Cannot remove from front: List is empty.");
        }
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        size--;
    }

    @Override
    public void insertBack(E element) {
        NodeElements<E> newNode = new NodeElements<>();
        newNode.DoublyNodeElements(element);
        newNode.previous = tail;
        newNode.next = null;
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void removeBack() {
        if (tail == null) {
            throw new IllegalStateException("Cannot remove from back: List is empty.");
        }
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    public void addAt(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            insertFront(element);
        } else if (index == size) {
            insertBack(element);
        } else {
            NodeElements<E> previousNode = getNodeAt(index - 1);
            add(previousNode, element);
        }
    }

    private void add(NodeElements<E> previousNode, E element) {
        if (previousNode == null) {
            throw new IllegalArgumentException("Previous node cannot be null.");
        }
        NodeElements<E> newNode = new NodeElements<>();
        newNode.DoublyNodeElements(element);
        NodeElements<E> nextNode = previousNode.next;
        newNode.previous = previousNode;
        newNode.next = nextNode;
        previousNode.next = newNode;
        if (nextNode != null) {
            nextNode.previous = newNode;
        }
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            removeFront();
        } else if (index == size - 1) {
            removeBack();
        } else {
            NodeElements<E> node = getNodeAt(index);
            remove(node);
        }
    }

    private void remove(NodeElements<E> n) {
        if (n == null) {
            throw new IllegalArgumentException("Node to remove cannot be null.");
        }
        NodeElements<E> previousNode = n.previous;
        NodeElements<E> nextNode = n.next;
        if (previousNode != null) {
            previousNode.next = nextNode;
        } else {
            head = nextNode;
        }
        if (nextNode != null) {
            nextNode.previous = previousNode;
        } else {
            tail = previousNode;
        }
        n.next = null;
        n.previous = null;
        size--;
    }

    public void displayReverse() {
        NodeElements<E> current = tail;
        if (current == null) {
            System.out.println("Empty list");
            return;
        }
        System.out.println("<-- End");
        while (current != null) {
            System.out.println(current.data);
            current = current.previous;
        }
        System.out.println("Start -->");
    }
}
