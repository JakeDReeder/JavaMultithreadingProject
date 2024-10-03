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
        
    }

    // Callable task for counting word occurrences
    static class WordSearchTask implements Callable<Integer> {
        private final String text;
        private final String word;

        public WordSearchTask(String text, String word) {
            this.text = text;
            this.word = word;
        }

        @Override
        public Integer call() {
            return countOccurrences(text, word);
        }

        private int countOccurrences(String text, String word) {
            return 0;
        }
    }
}
