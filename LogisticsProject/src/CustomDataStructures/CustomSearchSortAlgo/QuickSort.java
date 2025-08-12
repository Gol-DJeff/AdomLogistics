package CustomDataStructures.CustomSearchSortAlgo;

import CustomDataStructures.CustomArrayList;

public class QuickSort {

    /**
     * Partitions the array for quicksort.
     * @param array The CustomArrayList to partition.
     * @param low The starting index.
     * @param high The ending index.
     * @return The partition index.
     * @throws IllegalArgumentException if array is null or indices are invalid.
     */
    public int partitioner(CustomArrayList<String> array, int low, int high) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        if (low < 0 || high >= array.size() || low > high) {
            throw new IllegalArgumentException("Invalid indices: low=" + low + ", high=" + high);
        }

        String pivot = array.getElement(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            String current = array.getElement(j);
            if (current == null || pivot == null) {
                throw new IllegalArgumentException("Array elements cannot be null.");
            }
            if (current.compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Helper method to swap elements and handle exceptions
    private void swap(CustomArrayList<String> array, int i, int j) {
        if (i == j) return;
        String temp = array.getElement(i);
        array.setElement(i, array.getElement(j));
        array.setElement(j, temp);
    }
}
