package logical;

import java.util.*;

public class SimilarityFinder {
	public static void main(String[] args) {
		// Example text data (sentences)
		String[] sentences = {
				"Java programming language is versatile Java programming language is versatile Java programming language is versatile",
				"Python programming is easy to learn.", "Programming in Java requires understanding of JVM.",
				"Learning Python is useful for data science.",
				"Java programming language is versatile Java programming is versatile" };

		// Target sentence to find similarity with
		String targetSentence = "Java programming language is versatile Java programming language is versatile Java programming language is versatile";

		// Find the most similar sentence
		String mostSimilarSentence = findMostSimilarSentence(sentences, targetSentence);

		System.out.println("Target sentence: \"" + targetSentence + "\"");
		System.out.println("Most similar sentence: \"" + mostSimilarSentence + "\"");
	}

	// Method to find the most similar sentence to a target sentence
	public static String findMostSimilarSentence(String[] sentences, String targetSentence) {
		// Calculate word frequencies for target sentence
		Map<String, Integer> targetVector = calculateWordFrequency(targetSentence);

		// Calculate cosine similarity between target sentence and each other sentence
		double maxSimilarity = Double.MIN_VALUE;
		String mostSimilarSentence = "";

		for (String sentence : sentences) {
			if (!sentence.equals(targetSentence)) {
				Map<String, Integer> sentenceVector = calculateWordFrequency(sentence);
				double similarity = cosineSimilarity(targetVector, sentenceVector);
				if (similarity > maxSimilarity) {
					maxSimilarity = similarity;
					mostSimilarSentence = sentence;
				}
			}
		}
		System.out.println(maxSimilarity);
		return mostSimilarSentence;
	}

	// Method to calculate word frequency in a sentence
	public static Map<String, Integer> calculateWordFrequency(String sentence) {
		Map<String, Integer> freqMap = new HashMap<>();
		String[] words = sentence.toLowerCase().split("\\s+");

		for (String word : words) {
			freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
		}

		return freqMap;
	}

	// Method to calculate cosine similarity between two vectors (word frequency
	// maps)
	public static double cosineSimilarity(Map<String, Integer> vector1, Map<String, Integer> vector2) {
		Set<String> intersection = new HashSet<>(vector1.keySet());
		intersection.retainAll(vector2.keySet());

		double dotProduct = 0.0, norm1 = 0.0, norm2 = 0.0;

		/*
		 * for (String commonWord : intersection) { dotProduct +=
		 * vector1.get(commonWord) * vector2.get(commonWord); }
		 */
		dotProduct = intersection.stream().mapToDouble(commonWord -> vector1.get(commonWord) * vector2.get(commonWord))
				.sum();
		norm1 = vector1.values().stream().mapToDouble(d -> Math.pow(d, 2)).sum();
		norm2 = vector2.values().stream().mapToDouble(d -> Math.pow(d, 2)).sum();

		norm1 = Math.sqrt(norm1);
		norm2 = Math.sqrt(norm2);

		if (norm1 != 0 && norm2 != 0) {
			return dotProduct / (norm1 * norm2);
		} else {
			return 0.0; // Handle zero norm case
		}
	}
}
