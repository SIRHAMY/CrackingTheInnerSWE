
public class Main {
	public static void main(String[] args) {
		String[] word1 = new String[10];
		String[] word2 = new String[10];
		boolean[] answers = new boolean[10];
		PermutationChecker pCheck = new PermutationChecker();
		
		word1[0] = "";
		word2[0] = "";
		answers[0] = false;
		
		word1[1] = "dog";
		word2[1] = "god";
		answers[1] = true;
		
		word1[2] = "abc";
		word2[2] = "bac";
		answers[2] = true;
		
		word1[3] = "ba";
		word2[3] = "bac";
		answers[3] = false;
		
		word1[4] = "fuck";
		word2[4] = "bitc";
		answers[4] = false;

		for(int i = 0; i<word1.length; i++) 
		{
			if(word1[i] == null) break;
			System.out.println("Word1: " + word1[i]);
			System.out.println("Word2: " + word2[i]);
			System.out.println("Result: " + pCheck.isPermutation(word1[i], word2[i]));
			System.out.println("Answer: " + answers[i]);
		}
	}
}
