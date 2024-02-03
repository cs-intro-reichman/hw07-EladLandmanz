
public class SpellChecker {


	public static void main(String[] args) {
		 
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		
		
	}

	public static String tail(String str) {
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		if (word1.length()==0){
			return word2.length();
		}
		if (word2.length()==0){
			return word1.length();
		}
		if (Character.toLowerCase(word1.charAt(0)) == Character.toLowerCase(word2.charAt(0))){
			return levenshtein(tail(word1), tail(word2));
		}
		return (1 + Math.min(levenshtein(tail(word1), word2), Math.min(levenshtein(word1, tail(word2)),levenshtein(tail(word1), tail(word2)))));

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < dictionary.length; i++){
			dictionary[i] = in.readString();
			//System.out.println(dictionary[i]);
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int currentLevDiff = 0 , closestIndx = 0;
		int  minLevDiff = threshold + 1;
		for (int i = 0; i < dictionary.length; i++){
			currentLevDiff = levenshtein(word, dictionary[i]);
			if(currentLevDiff < minLevDiff){
				minLevDiff = currentLevDiff;
				closestIndx = i; 
			}
		}		
		if (minLevDiff <= threshold){
			return dictionary[closestIndx];
		}else{
			return word;
		}
	}

}
