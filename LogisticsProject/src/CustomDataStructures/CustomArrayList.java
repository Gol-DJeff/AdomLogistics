package CustomDataStructures;

public class CustomArrayList<T> {
    private T[] arrayInput; // Array to hold the elements
    private int size; // Current size of the array

    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        arrayInput = (T[]) new Object[2]; // Start with a slightly larger default size for efficiency
        size = 0;
    }

    public int size() {
        return size;
    }

    // Method to add an element to the array
    public void addElement(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot add null element.");
        }
        if (size == arrayInput.length) {
            resizeArray(arrayInput.length * 2); // Double the array size for better performance
        }
        arrayInput[size++] = value;
    }

    // Method to get an element at a specific index
    public T getElement(int index) {
        checkIndex(index);
        return arrayInput[index];
    }

    // Method to set an element at a specific index
    public void setElement(int index, T value) {
        checkIndex(index);
        if (value == null) {
            throw new IllegalArgumentException("Cannot set null element.");
        }
        arrayInput[index] = value;
    }

    // Method to remove an element at a specific index
    public T removeElement(int index) {
        checkIndex(index);
        T removedElement = arrayInput[index];
        for (int i = index; i < size - 1; i++) {
            arrayInput[i] = arrayInput[i + 1];
        }
        arrayInput[size - 1] = null;
        size--;
        if (size > 0 && size == arrayInput.length / 4) {
            resizeArray(arrayInput.length / 2); // Shrink the array if it's too empty
        }
        return removedElement;
    }

    // Method to check validity of the index
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    // Method to resize the array
    @SuppressWarnings("unchecked")
    private void resizeArray(int newCapacity) {
        if (newCapacity < 2) newCapacity = 2;
        T[] newDataSpace = (T[]) new Object[newCapacity];
        System.arraycopy(arrayInput, 0, newDataSpace, 0, size);
        arrayInput = newDataSpace;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        arrayInput = (T[]) new Object[2];
        size = 0;
    }
}
