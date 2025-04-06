package Exam_DAA;

import java.util.*;

public class Assignment22 {

    // Function to generate n-grams from text
    public static Set<String> generateNGrams(String text, int n) {
        Set<String> ngrams = new HashSet<>();
        text = text.toLowerCase().replaceAll("[^a-z0-9 ]", "");
        String[] words = text.split("\\s+");

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(words[i + j]).append(" ");
            }
            ngrams.add(sb.toString().trim());
        }
        return ngrams;
    }

    // Compare two documents using n-grams
    public static double calculateSimilarity(String doc1, String doc2, int n) {
        Set<String> ngrams1 = generateNGrams(doc1, n);
        Set<String> ngrams2 = generateNGrams(doc2, n);

        int matches = 0;
        for (String ngram : ngrams1) {
            if (ngrams2.contains(ngram)) matches++;
        }

        int total = Math.max(ngrams1.size(), ngrams2.size());
        return (double) matches / total * 100;
    }

    public static void main(String[] args) {
        String doc1 = "This is a sample document. It contains original text.";
        String doc2 = "This document is a sample. It contains some original text.";

        double similarity = calculateSimilarity(doc1, doc2, 3);
        System.out.printf("Plagiarism Score: %.2f%%\n", similarity);
    }
}
