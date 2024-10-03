// Jacob D Reeder
// CS 350

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedSearch {

    private final String text;
    private final String[] words;

    public MultithreadedSearch(String text, String[] words) {
        this.text = text;
        this.words = words;
    }

    public void performSearch() {

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(words.length);

        // Searching with multiple threads
        @SuppressWarnings("unchecked") //had a warning here.
        Future<Integer>[] futures = new Future[words.length];
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            futures[i] = executor.submit(new WordSearchTask(text, word));
        }

        // printing results
        for (int i = 0; i < words.length; i++) {
            try {
                int count = futures[i].get();
                System.out.println(words[i] + ": " + count );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken (Multithreaded): " + (endTime - startTime) + " ms");
    }

    // Separate class for counting.
    static class WordSearchTask implements Callable<Integer> {
        private final String text;
        private final String word;

        public WordSearchTask(String text, String word) {
            this.text = text;
            this.word = word;
        }

        @Override
        public Integer call() {
            // Use countOccurrences from SequentialSearch
            return SequentialSearch.countOccurrences(text, word);
        }
    }
}
