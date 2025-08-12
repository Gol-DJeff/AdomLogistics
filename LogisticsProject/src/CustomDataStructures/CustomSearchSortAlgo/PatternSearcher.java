package CustomDataStructures.CustomSearchSortAlgo;

import CustomDataStructures.CustomArrayList;

public class PatternSearcher {

    private String input;
    private String pattern;

    /**
     * Searches for any pattern in the input string using regex matching.
     * @param input The input string to search.
     * @param patterns The list of regex patterns to search for.
     * @return true if any pattern matches, false otherwise.
     * @throws IllegalArgumentException if input or patterns is null.
     */
    public boolean patternSearcher(String input, CustomArrayList<String> patterns) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        if (patterns == null) {
            throw new IllegalArgumentException("Pattern list cannot be null.");
        }

        this.input = input;
        for (int i = 0; i < patterns.size(); i++) {
            String currentPattern = patterns.getElement(i);
            if (currentPattern == null) {
                continue; // Skip null patterns
            }
            this.pattern = currentPattern;

            try {
                if (input.matches(currentPattern)) {
                    return true;
                }
            } catch (Exception e) {
                System.err.println("Invalid regex pattern at index " + i + ": " + currentPattern);
            }
        }
        System.out.println(input + " not found in any pattern.");
        return false;
    }
}
