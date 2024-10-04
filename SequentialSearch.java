// Jacob D Reeder
// CS 410

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
        int index = 0;
        int count = 0;
        word = word.toLowerCase();
        text = text.toLowerCase();

        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
