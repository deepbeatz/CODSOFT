import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Word Counter Program");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");
        System.out.print("Choose an option (1/2): ");
        
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        String text = "";
        
        if (option == 1) {
            System.out.print("Enter the text: ");
            text = scanner.nextLine();
        } else if (option == 2) {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            try {
                text = readFile(fileName);
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.err.println("Invalid option. Please choose 1 or 2.");
            System.exit(1);
        }

        if (text.isEmpty()) {
            System.err.println("Input is empty. Exiting.");
            System.exit(1);
        }

        String[] words = splitTextIntoWords(text);
        int totalWords = words.length;

        // Enhancements:
        // 7. Ignoring common words (stop words)
        List<String> stopWords = Arrays.asList("the", "and", "is", "in", "to", "a", "it"); // You can extend this list
        int nonStopWordsCount = countNonStopWords(words, stopWords);

        // 8. Provide statistics
        int uniqueWordsCount = countUniqueWords(words);
        Map<String, Integer> wordFrequency = getWordFrequency(words);

        // Display the results
        System.out.println("Total words: " + totalWords);
        System.out.println("Total non-stop words: " + nonStopWordsCount);
        System.out.println("Unique words: " + uniqueWordsCount);
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Read a text file and return its content as a string
    public static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // Split the text into an array of words using space or punctuation as delimiters
    public static String[] splitTextIntoWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words;
    }

    // Count non-stop words
    public static int countNonStopWords(String[] words, List<String> stopWords) {
        int count = 0;
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    // Count the number of unique words
    public static int countUniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        return uniqueWords.size();
    }

    // Get word frequency
    public static Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }
}
