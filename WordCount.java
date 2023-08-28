import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'text' to input text directly or 'file' to provide a file:");
        String choice = scanner.nextLine().trim();

        String text = "";
        if (choice.equalsIgnoreCase("text")) {
            System.out.println("Enter the text:");
            text = scanner.nextLine();
        } else if (choice.equalsIgnoreCase("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice. Exiting.");
            System.exit(1);
        }

        String[] words = text.split("\\s+|\\p{Punct}");
        List<String> stopWords = Arrays.asList("the", "and", "in", "of", "to", "a", "is", "with", "for");

        Map<String, Integer> wordFrequency = new HashMap<>();
        int totalWordCount = 0;

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word.toLowerCase())) {
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
                totalWordCount++;
            }
        }

        System.out.println("Total number of words: " + totalWordCount);
        System.out.println("Number of unique words: " + wordFrequency.size());

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return content.toString();
    }
}
