// Jacob D Reeder
// CS 410

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequentialSearch {

    private String text;
    private String[] words;

    public SequentialSearch(String text, String[] words) {
        this.text = text;
        this.words = words;
    }

    public void performSearch() {

        long startTime = System.currentTimeMillis();

        // Search sequentially
        for (String word : words) {
            int count = countOccurrences(text, word);
            System.out.println(word + ": " + count );
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken (Sequential): " + (endTime - startTime) + " ms");
    }

    // Count occurrences of a word
    public static int countOccurrences(String text, String word) {
        // Convert to lowercase for case-insensitive search
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();

        // Use regex to find whole word occurrences
        String regex = "\\b" + Pattern.quote(lowerWord) + "\\b"; // \\b for word boundaries
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lowerText);

        int count = 0;
        while (matcher.find()) {
            count++; // Increment the count for each match found
        }

        return count; // Return the total count of occurrences
    }
}
