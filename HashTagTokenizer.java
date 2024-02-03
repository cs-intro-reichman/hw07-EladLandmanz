

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		
		//System.out.println("naftali".substring(8));
		//breakHashTag("iloVErecursion", dictionary);

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++){
			dictionary[i] = in.readString();
			//System.out.println(dictionary[i]);
		}
		// Your code here

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		// Your code here
		
		for (int i = 0; i < dictionary.length; i++){
			if (word.length() == dictionary[i].length()){
				//System.out.println(i);
				if (stringEqusls(word, dictionary[i])){
					//System.out.println(i);
					return true;
				}
			}
		}
		return false;
	}
	public static boolean stringEqusls (String word1, String word2){
		for (int i = 0; i < word1.length(); i++){
			if (word1.charAt(i) != word2.charAt(i)){
				return false;
			}
		}
	
	
		return true;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		hashtag = hashtag.toLowerCase();
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		int startIndex = 0;

        for (int i = 1; i <= N; i++) {
			if (existInDictionary(hashtag.substring(0, i), dictionary)){
				System.out.println(hashtag.substring(0, i));
				breakHashTag(hashtag.substring(i), dictionary);
				return;
			}

        }
		
    }

}
