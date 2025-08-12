package CustomDataStructures;

public class CustomStack<E> {
    private final CustomArrayList<E> stackList; // Using CustomArrayList to hold stack elements

    public CustomStack() {
        stackList = new CustomArrayList<>(); // Initialize the CustomArrayList
    }

    // Pushes an item onto the top of the stack
    public E push(E item) {
        stackList.addElement(item); // Add the item to the stack
        return item; // Return the item that was pushed
    }

    // Removes and returns the item at the top of the stack
    public synchronized E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop: Stack is empty."); // Throw an exception if the stack is empty
        }
        int removeIndex = stackList.size() - 1; // Get the index of the last element
        return stackList.removeElement(removeIndex); // Remove the last element from the stack
    }

    // Returns the item at the top of the stack without removing it
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek: Stack is empty."); // Throw an exception if the stack is empty
        }
        int topIndex = stackList.size() - 1; // Get the index of the last element
        return stackList.getElement(topIndex); // Get the last element without removing it
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return stackList.size() == 0; // Check if the stack is empty
    }

    // Returns the number of items in the stack
    public int size() {
        return stackList.size(); // Get the current size of the stack
    }

    // Removes all items from the stack
    public void clear() {
        stackList.clear(); // Clear the stack by removing all elements
    }
}
