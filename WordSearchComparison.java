// Jacob D Reeder
// CS 410

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearchComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String filePath = "./King_James_Bible.txt";
            File file = new File(filePath);

            // Read the file content into a String
            String text = readFileContent(file);

            System.out.println("\n-------------------------------\n");  //just to make output look nicer :)
            System.out.print("Enter four words to search (comma-separated): ");
            String input = scanner.nextLine();
            String[] words = input.split(",\\s*"); // Split on commas and optional whitespace

            // Only take the first four words if more are provided
            if (words.length > 4) {
                String[] limitedWords = new String[4];
                System.arraycopy(words, 0, limitedWords, 0, 4);
                words = limitedWords;
            }

            System.out.println("\n-------------------------------\n"); 
            SequentialSearch sequentialSearch = new SequentialSearch(text, words);
            sequentialSearch.performSearch();

            System.out.println("\n-------------------------------\n"); 
            MultithreadedSearch multithreadedSearch = new MultithreadedSearch(text, words);
            multithreadedSearch.performSearch();

            System.out.println("\n-------------------------------\n"); 

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner
        }
    }

    private static String readFileContent(File file) throws FileNotFoundException {

        StringBuilder content = new StringBuilder();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine()).append("\n");
            }
        }
        return content.toString();
    }
}

